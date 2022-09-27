<template>
  <div
    class="modal"
    id="addCareerModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
    data-bs-backdrop="false"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">이력서 작성</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="career-items-header">학력사항</div>
          <hr />
          <div>
            <div class="row add-career-school">
              <div class="col-2" style="text-align:center; margin:auto">
                고등학교
              </div>
              <div class="col-3">
                <input
                  class="form-control"
                  type="text"
                  placeholder="학교명"
                  aria-label="default input example"
                />
              </div>
              <div class="col-3">
                <input
                  type="date"
                  id="addProjectStartDate"
                  min="1990-01-01"
                  class="add-project-standard-datepicker"
                />
              </div>
              <div class="col-1" style="text-align:center; margin:auto">
                ~
              </div>
              <div class="col-3">
                <input
                  type="date"
                  id="addProjectStartDate"
                  min="1990-01-01"
                  class="add-project-standard-datepicker"
                  value="1990-02-02"
                />
              </div>
            </div>
            <div class="row add-career-school">
              <div class="col-2" style="text-align:center; margin-top:5px">
                대학교
              </div>
              <div class="col-3">
                <input
                  class="form-control"
                  type="text"
                  placeholder="학교명"
                  aria-label="default input example"
                />
                <input
                  class="form-control"
                  type="text"
                  placeholder="전공"
                  aria-label="default input example"
                  style="margin-top:10px"
                />
              </div>
              <div class="col-3">
                <input
                  type="date"
                  id="addProjectStartDate"
                  min="1990-01-01"
                  class="add-project-standard-datepicker"
                />
              </div>
              <div class="col-1" style="text-align:center; margin-top:5px">
                ~
              </div>
              <div class="col-3">
                <input
                  type="date"
                  id="addProjectStartDate"
                  min="1990-01-01"
                  class="add-project-standard-datepicker"
                  value="1990-02-02"
                />
              </div>
            </div>
          </div>
          <div>경력사항</div>
          <hr />
          <div class="row add-career-career">
            <div class="col-2">회사명</div>
            <div class="col-10">
              <div class="row">
                <div class="col-4">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="회사명"
                    aria-label="default input example"
                  />
                </div>
                <div class="col-4">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="부서명"
                    aria-label="default input example"
                  />
                </div>
                <div class="col-4">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="직책명"
                    aria-label="default input example"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="row add-career-career">
            <div class="col-2">근무기간</div>
            <div class="col">
              <div class="row">
                <div class="col-3">
                  <input
                    type="date"
                    id="addProjectStartDate"
                    min="1990-01-01"
                    class="add-project-standard-datepicker"
                    style="margin:0"
                  />
                </div>
                <div class="col-1" style="text-align:center">~</div>
                <div class="col-4">
                  <input
                    type="date"
                    id="addProjectEndDate"
                    min="1990-01-01"
                    class="add-project-standard-datepicker"
                    style="margin:0"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="add-career-career" style="text-align:center">
            <hr style="width:95%;margin:auto;" />
          </div>
          <div class=" add-career-career" style="text-align:center">
            <div class="add-career-add-career-btn">
              <img
                src="@/assets/images/plus.png"
                style="width:36px; height:36px;margin-top: 22px;"
              />
            </div>
          </div>
          <div>자격사항</div>
          <hr />
          <div class="row add-career-career">
            <div class="col-2">
              자격증명
            </div>
            <div class="col">
              <div class="row">
                <div class="col-5">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="자격증명"
                    aria-label="default input example"
                  />
                </div>
                <div class="col">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="인증기관"
                    aria-label="default input example"
                  />
                </div>
              </div>
            </div>
          </div>
          <div class="row add-career-career">
            <div class="col-2">
              취득일자
            </div>
            <div class="col-10">
              <div class="row">
                <div class="col-5">
                  <input
                    class="form-control"
                    type="text"
                    placeholder="취득일자"
                    aria-label="default input example"
                  />
                </div>
                <div class="col"></div>
              </div>
            </div>
          </div>
          <div class="add-career-career" style="text-align:center">
            <hr style="width:95%;margin:auto;" />
          </div>
          <div class=" add-career-career" style="text-align:center">
            <div class="add-career-add-career-btn">
              <img
                src="@/assets/images/plus.png"
                style="width:36px; height:36px;margin-top: 22px;"
              />
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
          >
            취소
          </button>
          <button type="button" class="btn btn-primary">저장</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    freelancerDetailReceive: Object
  },
  data() {
    return {};
  }
};
</script>

<style>
.add-career-add-career-btn {
  border-radius: 10px;
  text-align: center;
  width: 95%;
  height: 80px;
  border: 1px dashed black;
  margin: auto;
}
.add-career-school {
  margin-bottom: 15px;
}
.add-career-career {
  margin-bottom: 15px;
}
</style>
