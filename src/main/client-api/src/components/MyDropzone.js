import axios from 'axios';
import { useCallback } from 'react';
import { useDropzone } from 'react-dropzone';

const MyDropzone = (props) => {
  const userProfileId = props.userProfileId;

  const onDrop = useCallback((acceptedFiles) => {
    const file = acceptedFiles[0];
    // console.log(file);
    const formData = new FormData();
    formData.append('file', file);
    axios
      .post(
        `http://localhost:8080/api/v1/user-profile/${userProfileId}/image/upload`,
        formData,
        {
          headers: {
            'Content-Type': 'multipart/form-data',
          },
        }
      )
      .then(() => {
        console.log('file uploaded successfully!');
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  const { getRootProps, getInputProps, isDragActive } = useDropzone({ onDrop });

  return (
    <div {...getRootProps()}>
      <input {...getRootProps} />
      {isDragActive ? (
        <p>Drop the files here ...</p>
      ) : (
        <p>Drag 'n' drop some files here, or clock to select files</p>
      )}
    </div>
  );
};

export default MyDropzone;
