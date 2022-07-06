<template>
  <div class="account">
    <div class="bx--grid">
      <div class="bx--row">
        <div class="bx--col blue-col">
          <!-- <p>1 of 2</p> -->
        </div>
        <div class="bx--col bx--col-sm-4">
          <LoginForm />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import LoginForm from "@/components/LoginForm";
export default {
  name: "Account",
  components: {
    LoginForm,
  },
};
</script>

<style lang="scss">
.account div.bx--row {
  height: calc(100vh - 3rem);
  margin-right: 0rem;
}

.account div.blue-col {
  background-image: url("../assets/farm_resized2.jpg");
  background-color: #0f62fe;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

.account .bx--grid {
  margin-right: auto;
  margin-left: 0rem;
  max-width: none;
  padding: 0;
}
</style>
