// userService.js
import axios from "axios";
import { createInstance } from "./index.js";

const instance = createInstance();

/** 여기서 부터 만듬 */
/** 프리랜서 회원가입 */
function signupFreelancer(userInfo, success, fail) {
  console.log(userInfo);
  // console.log("여긴옴?");
  // console.log(userInfo);
  const registerInfo = {
    email: userInfo.email + userInfo.emailDomain,
    name: userInfo.name,
    password: userInfo.password,
    phone: userInfo.number,
    username: userInfo.id
  };
  console.log(registerInfo);

  instance
    .post("/users", registerInfo, {
      headers: {
        "Content-Type": "application/json"
      }
    })
    .then(success);
}
/** 프리랜서 전체 조회 */
function getUserList(searchOption, success, fail) {
  instance
    .get("/users", {
      params: searchOption
    })
    .then(success)
    .catch(fail);
}

/** 프리랜서 필터링 조회 */
function getFilterUserList(techList, success, fail) {
  instance
    .get("/users/filter", {
      params: techList
    })
    .then(success)
    .catch(fail);
}
/** 프로필 등록 */
function setUserProfile(profileContent, success, fail) {
  instance
    .post("/users/profile", profileContent)
    .then(success)
    .catch(fail);
}
/** 프로필 수정 */
function changeUserProfile(profileContent, success, fail) {
  instance
    .patch("/users/profile", profileContent)
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로필 조회 */

function getUserProfile(username, success, fail) {
  instance
    .get(`/users/profile/${username}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 기술 조회 */

function getUserTech(profileId, success, fail) {
  instance
    .get(`/users/profile/tech/${profileId}`)
    .then(success)
    .catch(fail);
}
/** 프리랜서 기술 등록 */

function setUserTech(techList, username, success, fail) {
  instance
    .post(`/users/profile/tech/${username}`, techList)
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로젝트 이력 등록 */

function setUserProject(registerProfileInfo, success, fail) {
  instance
    .post(`user/project`, registerProfileInfo)
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로젝트 이력 삭제 */

function deleteUserProject(projectCareerId, success, fail) {
  instance
    .delete(`user/project/${projectCareerId}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 이력 조회 */

function getUserProject(username, success, fail) {
  instance
    .get(`user/project/${username}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로젝트 이력 기술 조회 */
function getUserProjectTech(projectCareerId, success, fail) {
  instance
    .get(`user/project/tech/${projectCareerId}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로젝트 이력 기술 등록 */

function setUserProjectTech(username, success, fail) {
  instance
    .post(`user/project/tech/${username}`)
    .then(success)
    .catch(fail);
}

/** 유저 이력 사항 등록 */

function setUserResume(registerResumeInfo, success, fail) {
  instance
    .post(`user/resume`, registerResumeInfo)
    .then(success)
    .catch(fail);
}

/** 프리랜서 이력사항 조회 */

function getUserResume(username) {
  instance
    .get(`user/resume/${username}`)
    .then(success)
    .catch(fail);
}

export {
  signupFreelancer,
  getUserResume,
  setUserResume,
  setUserProjectTech,
  getUserProjectTech,
  getUserProject,
  deleteUserProject,
  setUserProject,
  setUserTech,
  getUserTech,
  getUserProfile,
  changeUserProfile,
  setUserProfile,
  getFilterUserList,
  getUserList
};
