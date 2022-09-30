<template>
  <div>
    <div class="d-flex justify-content-end">
      <button @click="deleteMessage" class="delete-message-button">
        선택 삭제
      </button>
    </div>
    <hr />
    <div>
      <div
        class="accordion-item"
        v-for="(item, index) in messages"
        :key="index"
      >
        <message-detail :message="item" :index="index"></message-detail>
      </div>
    </div>
  </div>
</template>

<script>
import MessageDetail from "./FreelancerMessage/MessageDetail.vue";
export default {
  components: {
    MessageDetail
  },
  data() {
    return {
      selected_messages: [],
      messages: [
        {
          message_id: 1,
          title: "인터뷰 요청이 들어왔습니다.",
          content:
            "AI기반 Firescout 솔루션 ux/ui 디자인에서 인터뷰 요청이 들어왔어요. 자세히 보기를 클릭하여 프로젝트를 확인해보세요!",
          open: false,
          contract: "a",
          state: 0,
          company_id: 3,
          freelancer_id: 3,
          project_id: 3
        },
        {
          message_id: 2,
          title: "인터뷰 일정을 확인해주세요.",
          content: "2번 내용",
          open: true,
          contract: "b",
          state: 0,
          company_id: 3,
          freelancer_id: 3,
          project_id: 3
        },
        {
          message_id: 3,
          title: "계약이 체결되었습니다.",
          content: "3번 내용",
          open: true,
          contract: "c",
          state: 0,
          company_id: 3,
          freelancer_id: 3,
          project_id: 3
        }
      ]
    };
  },
  methods: {
    deleteMessage() {
      console.log("deletemessage");
    }
  }
};
</script>

<style>
.delete-message-button {
  padding: 5px 20px 5px 20px;
  background: #3f79d1;
  border: 1px solid #eaf5fb;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 45px;
  font-weight: bold;
  color: white;
}
</style>
