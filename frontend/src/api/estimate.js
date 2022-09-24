// estimate.js
import { createInstance } from "./index.js";

const instance = createInstance();

function getUserEstimate(username, success, fail) {
  instance
    .get(`/estimate/${username}`)
    .then(success)
    .catch(fail);
}

function setUserEstimate(username, registerEstimateInfo, success, fail) {
  instance
    .post(`/estimates/${username}`)
    .then(success)
    .catch(fail);
}

export { getUserEstimate, setUserEstimate };
