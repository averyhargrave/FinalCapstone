<template>
  <div :style="image" class="background-image">
    <h1></h1>
    <home />
  </div>
</template>

<script>
import Home from "@/components/Home.vue"
export default {
  components: {
    Home
  },
  data() {
    return {
      image: { backgroundImage: "url(https://cleveland-bookkeeping.com/wp-content/uploads/2016/06/Moonrise-over-the-Cleveland-Ohio-skyline-and-Lake-Erie.jpg)"}
    }
  }
};
</script>

<style scoped>


 div.background-image {
        background-size: cover;
        height: 100vmax;
        background-repeat: no-repeat;
        margin: -100px;
    }


</style>

