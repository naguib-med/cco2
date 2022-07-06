<template>
  <div class="ecosystem">
    <h1>About the CCo2 ecosystem</h1>
    <div class="content">
      <div>
        <ul class="front">
          <li class="list"></li>
          <li class="list"></li>
          <li class="list"></li>
        </ul>
      </div>

      <ul class="back">
        <li class="list"></li>
        <li class="list"></li>
        <li class="list"></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Ecosystem",
  components: {},
};
</script>

<style lang="scss">
.ecosystem h1 {
  margin-top: 4rem;
}
.ecosystem .list {
  padding: 2rem;
  margin-left: 2rem;
  text-align: left;
  font-size: 1.3rem;
}

.ecosystem .font {
  padding: 3rem;
  margin: 3rem;
  background-color: #f2f4f4;
}
</style>
