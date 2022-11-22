// estimate.js
import { createInstance } from "./index.js";

const instance = createInstance();

async function getUserEstimate(username, success, fail) {
  console.log(username);
  await instance
    .get(`/estimates/${username}`)
    .then(success)
    .catch(fail);
}

async function setUserEstimate(qdata, success, fail) {
  const username = data.username;
  const registerEstimateInfo = data.registerEstimateInfo;
  await instance
    .post(`/estimates/${username}`, registerEstimateInfo)
    .then(success)
    .catch(fail);
}

export { getUserEstimate, setUserEstimate };
