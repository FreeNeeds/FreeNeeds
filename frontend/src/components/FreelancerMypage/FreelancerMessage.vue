<template>
  <div>
    <div class="d-flex justify-content-end">
      <button @click="deleteMessage" class="delete-message-button">
        선택 삭제
      </button>
    </div>
    <hr />
    <div v-for="(item, index) in messages" :key="index">
      <div class="message-title">
        {{ item.title }}
      </div>

      <div class="message-contents">{{ item.content }}</div>
      <hr />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selected_messages: [],
      messages: [
        {
          title: "메세지 1",
          content: "1번 내용",
          open: false,
          contract: "a",
          state: 0,
          company_id: 3,
          freelancer_id: 3,
          project_id: 3
        },
        {
          title: "메세지 2",
          content: "2번 내용",
          open: true,
          contract: "b",
          state: 0,
          company_id: 3,
          freelancer_id: 3,
          project_id: 3
        },
        {
          title: "메세지 3",
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
.message-contents {
  display: none;
}
</style>
