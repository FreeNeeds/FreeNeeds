// company.js

import { createInstance } from "./index.js";

const instance = createInstance();

/** 기업 회원 가입 */
function signupCompany(companyInfo, success, fail) {
  const data = {
    email: companyInfo.email + companyInfo.emailDomain,
    name: companyInfo.name,
    password: companyInfo.password,
    phone: companyInfo.number,
    username: companyInfo.id
  };
  instance
    .post(`/companies`, data)
    .then(success)
    .catch(fail);
}

/** 기업 정보 생성 */
function setCompanyInfo(companyInfo, success, fail) {
  instance
    .post(`/companies/information`, companyInfo)
    .then(success)
    .catch(fail);
}

/** 기업 정보 수정 */
function changeCompanyInfo(companyInfo, success, fail) {
  instance
    .patch(`/companies/information`, companyInfo)
    .then(success)
    .catch(fail);
}

/** 기업 정보 조회 */
function getCompanyInfo(username, success, fail) {
  instance
    .get(`/companies/information/${username}`)
    .then(success)
    .catch(fail);
}

/** 기업 회원 조회 */
function getCompanyUserInfo(success, fail) {
  instance
    .get(`companies/me`)
    .then(success)
    .catch(fail);
}

/** 기업 회원 정보 수정 */
function changeCompanyUserInfo(userInfo, success, fail) {
  instance
    .patch(`/companies/me`)
    .then(success)
    .catch(fail);
}

export {
  signupCompany,
  setCompanyInfo,
  changeCompanyInfo,
  getCompanyInfo,
  getCompanyUserInfo,
  changeCompanyUserInfo
};
