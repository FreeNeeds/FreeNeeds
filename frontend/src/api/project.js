// project.js
import { createInstance } from "./index.js";

const instance = createInstance();

/** 프로젝트 전체 조회 */
function getProjectList(filter, success, fail) {
  instance
    .get(`/project`, {
      params: filter
    })
    .then(success)
    .catch(fail);
}

/** 프로젝트 등록 */
function registProject(registerInfo, success, fail) {
  instance
    .post(`/project`, registerInfo)
    .then(success)
    .catch(fail);
}

/** 프로젝트 상세 정보 조회 */
function getProjectInfo(projectId, success, fail) {
  instance
    .get(`/project/${projectId}`)
    .then(success)
    .catch(fail);
}

/** 프로젝트 필터링 조회 */
function getFilterProject(filter, success, fail) {
  instance
    .get(`/project/filter`)
    .then(success)
    .catch(fail);
}

/** 프로젝트 관련 기술 조회 */
function getProjectTech(projectId, success, fail) {
  instance
    .get(`/project/tech/${projectId}`)
    .then(success)
    .catch(fail);
}

function setProjectTech(projectId, success, fail) {
  instance
    .post(`/project/tech/${projectId}`)
    .then(success)
    .catch(fail);
}

export {
  getProjectList,
  registProject,
  getProjectInfo,
  getFilterProject,
  getProjectTech,
  setProjectTech
};
