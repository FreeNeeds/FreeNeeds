// company.js

import { createInstance } from "./index.js";

const instance = createInstance();

/** 기업 회원 가입 */
async function signupCompany(companyInfo, success, fail) {
  const data = {
    email: companyInfo.email + companyInfo.emailDomain,
    name: companyInfo.name,
    password: companyInfo.password,
    phone: companyInfo.number,
    username: companyInfo.id,
    accountAddress : companyInfo.accountAddress
  };
  await instance
    .post(`/companies`, data)
    .then(success)
    .catch(fail);
}

/** 기업 정보 생성 */
async function setCompanyInfo(companyInfo, success, fail) {
  await instance
    .post(`/companies/information`, companyInfo)
    .then(success)
    .catch(fail);
}

/** 기업 정보 수정 */
async function changeCompanyInfo(companyInfo, success, fail) {
  await instance
    .patch(`/companies/information`, companyInfo)
    .then(success)
    .catch(fail);
}

/** 기업 정보 조회 */
async function getCompanyInfo(username, success, fail) {
  await instance
    .get(`/companies/information/${username}`)
    .then(success)
    .catch(fail);
}

/** 기업 회원 조회 */
async function getCompanyUserInfo(success, fail) {
  await instance
    .get(`companies/me`)
    .then(success)
    .catch(fail);
}

/** 기업 회원 정보 수정 */
async function changeCompanyUserInfo(userInfo, success, fail) {
  await instance
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
