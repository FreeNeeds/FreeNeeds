// apply.js
import { createInstance } from "./index.js";
// import store from "@/store/index.js";
// store.state.user.access_token.token와 같은 형식으로 토큰 가져올 수 있음.
const instance = createInstance();

/** 지원 상태 조회 */
async function getApplyStatus(userId, success, fail) {
  await instance
    .get(`apply`, {
      params: {
        userId: userId
      }
    })
    .then(success)
    .catch(fail);
}

/** 지원하기 */
async function ApplyProject(applyReq, success, fail) {
  await instance
    .post(`apply`, applyReq)
    .then(success)
    .catch(fail);
}

/** 지원 상태 변경 */
async function ChangeApplyInfo(applyReq, success, fail) {
  console.log(applyReq);
  await instance
    .put(`apply`, applyReq)
    .then(success)
    .catch(fail);
}

/** 지원 취소 */
async function cancelApply(applyDeleteReq, success, fail) {
  await instance
    .delete(`apply`, {
      data: {
        projectId: applyDeleteReq.projectId,
        userId: applyDeleteReq.userId
      }
    })
    .then(success)
    .catch(fail);
}

export { cancelApply, ChangeApplyInfo, ApplyProject, getApplyStatus };
