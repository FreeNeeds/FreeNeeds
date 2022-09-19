import { createInstance } from "./index.js";

const instance = createInstance();

function findProjectListByFilter(category,form,skill,region) {
  instance
    .get("/" + category + "/" + form + "/" + skill + "/" + region + "/")
    .then(res => {
      console.log(res)
    })
}

export { findProjectListByFilter }