<template>
  <div class="login-form">
    <h1 class="login-form-title">Login</h1>
    <cv-form @submit.prevent="actionSubmit">
      <cv-text-input
        label="Username"
        helper-text="Type your account username here"
        placeholder="Your username"
        id="username"
      >
      </cv-text-input>

      <cv-text-input
        label="Password"
        helper-text="Forgot your password ?"
        placeholder="Your password"
        type="password"
        id="password"
      >
      </cv-text-input>

      <cv-button class="login-btn"
        >Manage your farm <ChevronRight20 class="login-btn-icon"
      /></cv-button>
    </cv-form>
    <hr class="form-divider" />
    <p class="text-signup" to="/who">
      <span class="link-text-actual">You don't have an account yet ?</span>
      <router-link class="link-signup-actual" to="/account-signup"
        >Sign Up</router-link
      >
      <ChevronRight20 />
    </p>
  </div>
</template>

<script>
import { ChevronRight20 } from "@carbon/icons-vue";

export default {
  name: "LoginForm",
  components: {
    ChevronRight20,
  },
  data: function () {
    return {
      routeRegister: "https://192.168.74.198/api/login",
    };
  },
  methods: {
    async actionSubmit() {
      let name = document.querySelector(".login-form #username").value;
      let p1 = document.querySelector(".login-form #password").value;

      document.querySelector(".login-form #password").value = "";
      document.querySelector(".login-form #username").value = "";

      let data = "username=" + name + "&password=" + p1;
      console.log(data);

      let res = await fetch(this.routeRegister, {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/x-www-form-urlencoded", // <-- Specifying the Content-Type
        }),
        body: data,
      });

      if (res.status === 200) {
        let key = await res.text();
        this.$store.commit("updateToken", key);
      }
    },
  },
};
</script>

<style lang="scss">
.login-form-title {
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: normal;
  font-size: 30px;
  line-height: 26px;
  text-align: left;
  color: #161616;
  margin-bottom: 1.5rem;
}

.bx--label {
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 12px;
  line-height: 16px;
  letter-spacing: 0.32px;
  color: #525252;
}

.bx--form__helper-text {
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: normal;
  font-size: 12px;
  line-height: 16px;
  letter-spacing: 0.32px;

  text-align: left;
  color: #525252;
}

.bx--text-input-wrapper {
  margin-bottom: 1.5rem;
}

div.login-form {
  margin-top: 6rem;
  margin-left: 4rem;
  margin-right: 4rem;
}

.login-btn {
  padding-right: 15px;
  float: right;
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 14px;
  line-height: 18px;
  letter-spacing: 0.16px;
  color: #ffffff;
}

.login-btn-icon {
  margin-left: 40px;
}

.form-divider {
  margin-top: 6.5rem;
  border-color: #c0c0c0;
  margin-left: 3rem;
  margin-right: 3rem;
  margin-bottom: 1.5rem;
  height: 1px;
}

.text-signup {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row;
}

.text-signup > .link-signup-actual {
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 16px;
  line-height: 26px;
  text-decoration: none;
  color: #161616;
  margin-left: 0.5rem;
}

.link-text-actual {
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 12px;
  line-height: 16px;
  color: #525252;
}

.text-signup > svg:nth-child(2) {
  margin-top: 0.5rem;
  line-height: 50px;
}
</style>
