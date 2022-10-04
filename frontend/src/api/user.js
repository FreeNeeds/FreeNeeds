// userService.js
import axios from "axios";
import { createInstance } from "./index.js";
import store from "@/store/index.js";
const instance = createInstance();
import qs from "qs";
/** 여기서 부터 만듬 */
/** 프리랜서 회원가입 */
async function signupFreelancer(userInfo, success, fail) {
  console.log(userInfo);
  // console.log("여긴옴?");
  // console.log(userInfo);
  const registerInfo = {
    email: userInfo.email + userInfo.emailDomain,
    name: userInfo.name,
    password: userInfo.password,
    phone: userInfo.number,
    username: userInfo.id,
    accountAddress: userInfo.accountAddress
  };
  console.log(registerInfo);

  await instance
    .post("/users", registerInfo, {
      headers: {
        "Content-Type": "application/json"
      }
    })
    .then(success)
    .catch(fail);
}
/** 프리랜서 전체 조회 */
async function getUserList(searchOption, success, fail) {
  await instance
    .get(`/users?page=${searchOption.page}&size=${searchOption.size}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 필터링 조회 */
async function getFilterUserList(filterdata, success, fail) {
  console.log(qs.stringify(filterdata.techList, { arrayFormat: "comma" }));
  await instance
    .get("/users/filter", {
      params: {
        page: filterdata.page,
        size: filterdata.size,
        techList: filterdata.techList.join(",")
      }
    })
    .then(success)
    .catch(fail);
}

/** 프로필 등록 */
async function setUserProfile(profileContent, success, fail) {
  await instance
    .post("/users/profile", profileContent, {
      headers: store.getters.authHeader
    })
    .then(success)
    .catch(fail);
}
/** 프로필 수정 */
async function changeUserProfile(profileContent, success, fail) {
  await instance
    .patch("/users/profile", profileContent, {
      headers: store.getters.authHeader
    })
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로필 조회 */

async function getUserProfile(username, success, fail) {
  await instance
    .get(`/users/profile/${username}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 기술 조회 */

async function getUserTech(profileId, success, fail) {
  await instance
    .get(`/users/profile/tech/${profileId}`)
    .then(success)
    .catch(fail);
}
/** 프리랜서 기술 등록 */

async function setUserTech(techList, username, success, fail) {
  console.log(store.getters.authHeader);
  var headeradd = store.getters.authHeader;
  console.log(username);
  console.log(techList);
  await instance
    .post(
      `/users/profile/tech/${username}`,
      {},
      {
        params: { techList: techList },
        paramsSerializer: params => {
          return qs.stringify(params, { arrayFormat: "comma" });
        },
        headeradd
      }
    )
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로젝트 이력 등록 */

async function setUserProject(registerProfileInfo, success, fail) {
  await instance
    .post(`users/project`, registerProfileInfo, {
      headers: store.getters.authHeader
    })
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로젝트 이력 삭제 */

async function deleteUserProject(projectCareerId, success, fail) {
  await instance
    .delete(`users/project/${projectCareerId}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 이력 조회 */

async function getUserProject(username, success, fail) {
  await instance
    .get(`users/project/${username}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로젝트 이력 기술 조회 */
async function getUserProjectTech(projectCareerId, success, fail) {
  await instance
    .get(`users/project/tech/${projectCareerId}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 프로젝트 이력 기술 등록 */

async function setUserProjectTech(projectId, techList, success, fail) {
  var headeradd = store.getters.authHeader;
  await instance
    .post(
      `users/project/tech/${projectId}`,
      {},
      {
        params: { techList: techList },
        paramsSerializer: params => {
          return qs.stringify(params, { arrayFormat: "comma" });
        },
        headeradd
      }
    )
    .then(success)
    .catch(fail);
}

/** 유저 이력 사항 등록 */
async function setUserResume(registerResumeInfo, success, fail) {
  await instance
    .post(`users/resume`, registerResumeInfo, {
      headers: store.getters.authHeader
    })
    .then(success)
    .catch(fail);
}

/** 프리랜서 이력사항 조회 */

async function getUserResume(username, success, fail) {
  await instance
    .get(`users/resume/${username}`)
    .then(success)
    .catch(fail);
}

/** 프리랜서 지갑 주소 조회 */
async function getUserAccountAddress(userId, success, fail) {
  await instance
    .get(`users/account/${userId}`)
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
  getUserList,
  getUserAccountAddress
};
