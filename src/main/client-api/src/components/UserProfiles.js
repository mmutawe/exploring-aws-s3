import { useState, useEffect } from 'react';
import axios from 'axios';

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
      <div>
        <h1> {userProfile.username} </h1>
        <p> {userProfile.userProfileId} </p>
      </div>
    );
  });
};

export default UserProfiles;
