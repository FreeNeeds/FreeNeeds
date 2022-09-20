import { createInstance } from "./index.js";

const instance = createInstance();

function findProjectListByFilter(category,form,skill,region) {
  instance
    .get("/" + category + "/" + form + "/" + skill + "/" + region + "/")
    .then(res => {
      console.log(res)
    })
}

function applyCompany(projectId) {
  const body = {
    "user_id" : sessionStorage.getItem("user").user_id,
    "project_id" : projectId,
    "state" : "지원완료"
  }
  instance
    .post("/apply/",JSON.stringify(body))
    .then(res => {
      console.log(res)
    })
}
export { findProjectListByFilter , applyCompany }