<template>
  <b-container>
    <!--상단 네비게이션 바-->
    <HeaderNav></HeaderNav>

    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        caption="First slide"
        text="Nulla vitae elit libero, a pharetra augue mollis interdum."
        img-src="https://picsum.photos/1024/480/?image=52"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">
        <h1>Hello world!</h1>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide
        img-src="https://picsum.photos/1024/480/?image=58"
      ></b-carousel-slide>

      <!-- Slides with img slot -->
      <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
      <b-carousel-slide>
        <template #img>
          <img
            class="d-block img-fluid w-100"
            width="1024"
            height="480"
            src="https://picsum.photos/1024/480/?image=55"
            alt="image slot"
          />
        </template>
      </b-carousel-slide>

      <!-- Slide with blank fluid image to maintain slide aspect ratio -->
    </b-carousel>
    <!--상단 네비게이션 바 끄읕-->

    <h1 class="list-title">인기 프리랜서 목록</h1>
    <!--인기 프리랜서 목록-->
    <b-card-group deck class="card-list">
      <b-card
        class="card"
        border-variant="primary"
        header="Primary"
        header-bg-variant="primary"
        header-text-variant="white"
        align="center"
      >
        <b-card-text
          >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</b-card-text
        >
      </b-card>

      <b-card
        class="card"
        border-variant="secondary"
        header="Secondary"
        header-border-variant="secondary"
        align="center"
      >
        <b-card-text
          >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</b-card-text
        >
      </b-card>

      <b-card
        class="card"
        border-variant="success"
        header="Success"
        align="center"
      >
        <b-card-text
          >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</b-card-text
        >
      </b-card>
    </b-card-group>
    <!--인기 프리랜서 목록 끄읕-->
    <h1 class="list-title">인기 프로젝트 목록</h1>
    <!--인기 프로젝트 목록-->
    <b-card-group deck class="card-list">
      <b-card
        border-variant="primary"
        header="Primary"
        header-bg-variant="primary"
        header-text-variant="white"
        align="center"
      >
        <b-card-text
          >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</b-card-text
        >
      </b-card>

      <b-card
        border-variant="secondary"
        header="Secondary"
        header-border-variant="secondary"
        align="center"
      >
        <b-card-text
          >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</b-card-text
        >
      </b-card>

      <b-card border-variant="success" header="Success" align="center">
        <b-card-text
          >Lorem ipsum dolor sit amet, consectetur adipiscing elit.</b-card-text
        >
      </b-card>
    </b-card-group>
    <!--인기 프로젝트 목록 끄읕-->

    <div class="mt-4">
      <h4>Left Image</h4>
      <b-card
        img-src="https://placekitten.com/300/300"
        img-alt="Card image"
        img-left
        class="mb-3"
      >
        <b-card-text>
          사이트 설명1
        </b-card-text>
      </b-card>
    </div>

    <div class="mt-4">
      <h4>Right Image</h4>
      <b-card
        img-src="https://placekitten.com/300/300"
        img-alt="Card image"
        img-right
      >
        <b-card-text>
          사이트 설명2
        </b-card-text>
      </b-card>
    </div>
    <FooterNav></FooterNav>
  </b-container>
</template>
<script>
import HeaderNav from "@/components/HeaderNav.vue";
import FooterNav from "@/components/FooterNav.vue";

export default {
  data() {
    return {
      slide: 0,
      sliding: null
    };
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    }
  },
  components: {
    HeaderNav,
    FooterNav
  }
};
</script>
<style>
.list-title {
  text-align: center;
  margin-top: 80px;
  margin-bottom: 40px;
}
.card-list {
  height: 300px;
}
</style>
