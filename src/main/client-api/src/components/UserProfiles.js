import { useState, useEffect } from 'react';
import axios from 'axios';

import MyDropzone from './MyDropzone';

const UserProfiles = () => {
  const [userProfiles, setUserProfiles] = useState([]);

  const fetchUserProfile = () => {
    axios.get('http://localhost:8080/api/v1/user-profile').then((res) => {
      console.log(res);
      setUserProfiles(res.data);
    });
  };

  useEffect(() => {
    fetchUserProfile();
  }, []);

  return userProfiles.map((userProfile, index) => {
    return (
      <div key={index}>
        {userProfile.userProfileId ? (
          <img
            src={`http://localhost:8080/api/v1/user-profile/${userProfile.userProfileId}/image/download`}
          />
        ) : null}
        <br />
        <h1> {userProfile.username} </h1>
        <p> {userProfile.userProfileId} </p>
        <MyDropzone userProfileId={userProfile.userProfileId} />
      </div>
    );
  });
};

export default UserProfiles;
