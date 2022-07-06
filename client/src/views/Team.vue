<template>
  <div class="team">
    <h1>About the CCo2 team</h1>

    <div class="container">
      <div class="row">
        <div class="column-66">
          <h2>Name : Melvyn Bertolone</h2>
          <h4>Role : Manager du projet, responsable UI/UX</h4>
          <p>
            I am responsible for the management of the group and responsible for
            the graphical interfaces.
          </p>
        </div>
        <div class="column-33">
          <img src="../assets/profile-men.png" alt="" />
        </div>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="column-33">
          <img src="../assets/profile-men.png" alt="" />
        </div>
        <div class="column-66">
          <h2>Name : Célian Louis-Itty</h2>
          <h4>Role : Frontend</h4>
          <p>I am responsible for the front end part of the application.</p>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="column-66">
          <h2>Name : MOHAMED MAHAMOUD Naguib</h2>
          <h4>Role : Frontend</h4>
          <p>I am responsible for the front end part of the application.</p>
        </div>
        <div class="column-33">
          <img src="../assets/profile-men.png" alt="" />
        </div>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="column-33">
          <img src="../assets/profile-femme.jpg" alt="" />
        </div>
        <div class="column-66">
          <h2>Name : Cécile Zagala</h2>
          <h4>Role : Backend</h4>
          <p>I am responsible for the back-end part of the application.</p>
        </div>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="column-66">
          <h2>Name : Hichem Djeghri</h2>
          <h4>Role : Backend (data)</h4>
          <p>
            I am responsible for the back-end part of the application and the
            data collection.
          </p>
        </div>
        <div class="column-33">
          <img src="../assets/profile-men.png" alt="" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Team",
  components: {},
};
</script>

<style lang="scss">
.team .container {
  padding: 3rem;
}

.team h1 {
  margin-top: 5rem;
}
/* Clear floats */
.team .row:after {
  content: "";
  display: table;
  clear: both;
}

.team .row {
  background-color: #f2f4f4;
  padding: 2rem;
}

/* 2/3 column */
.team .column-66 {
  float: left;
  width: 66.66666%;
  padding: 20px;
  margin-top: 5rem;
}

/* 1/3 column */
.team .column-33 {
  float: left;
  width: 33.33333%;
  padding: 20px;
}

.team img {
  display: block;
  height: auto;
  max-width: 100%;
}

/* Add responsiveness - make the columns appear on top of each other instead of next to each other on small screens */
@media screen and (max-width: 1000px) {
  .team .column-66,
  .team .column-33 {
    width: 100%;
    text-align: center;
  }
  .team img {
    margin: auto;
  }
}
</style>
