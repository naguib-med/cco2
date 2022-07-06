<template>
  <div class="minerVue">
    <cv-grid>
      <cv-row>
        <cv-column :sm="4" :md="4" :lg="6">
          <h1>Resume</h1>
          <div class="resumeBox">
            <p>
              <span><Chip32 /></span>x Miners
            </p>
            <p>
              <span
                ><svg
                  color
                  width="32"
                  height="32"
                  viewBox="0 0 32 32"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M24.9999 8.64001C21.4929 8.64001 18.6399 11.493 18.6399 15V25C18.6399 
              28.11 16.1099 30.64 12.9999 30.64C9.88989 30.64 7.35989 28.11 7.35989 25V19.342C10.6989 
              19.154 13.3599 16.385 13.3599 13V5.00001C13.3599 4.80101 13.1989 4.64001 12.9999 4.64001H10.3599V1.00001C10.3599 
              0.801015 10.1989 0.640015 9.99989 0.640015C9.80089 0.640015 9.63989 0.801015 9.63989 
              1.00001V4.64001H4.35989V1.00001C4.35989 0.801015 4.19889 0.640015 3.99989 0.640015C3.80089 
              0.640015 3.63989 0.801015 3.63989 1.00001V4.64001H0.999893C0.800893 4.64001 0.639893 4.80101 
              0.639893 5.00001V13C0.639893 16.385 3.30089 19.154 6.63989 19.342V25C6.63989 28.507 9.49289 31.36 12.9999 
              31.36C16.5069 31.36 19.3599 28.506 19.3599 25V15C19.3599 11.89 21.8889 9.36001 24.9999 9.36001C28.1109 9.36001 
              30.6399 11.89 30.6399 15V25H31.3609V15C31.3599 11.493 28.5069 8.64001 24.9999 8.64001ZM1.35989 
              5.36001H12.6399V8.64001H1.35989V5.36001ZM1.35989 13V9.36001H12.6399V13C12.6399 16.11 10.1099 18.64 
              6.99989 18.64C3.88989 18.64 1.35989 16.11 1.35989 13Z"
                    fill="black"
                  />
                </svg> </span
              >Electrical consumption : x W
            </p>
            <p>
              <span>
                <svg
                  width="32"
                  height="32"
                  viewBox="0 0 20 26"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M1.00002 9.36001C0.987023 9.36001 0.974023 9.36001 0.960023 9.35801C0.762023 9.33601 0.620024 9.15801 
                0.642024 8.96101C1.16702 4.21701 5.18902 0.640015 10 0.640015C14.811 0.640015 18.834 4.21701 19.357 8.96001C19.379 
                9.15801 19.237 9.33501 19.039 9.35701C18.849 9.38001 18.663 9.23601 18.643 9.03901C18.158 4.66201 14.443 1.36001 
                10 1.36001C5.55702 1.36001 1.84202 4.66201 1.35802 9.04001C1.33702 9.22401 1.18202 9.36001 1.00002 9.36001ZM18.623 
                13L14.961 24.903L10.348 13H9.65302L5.04002 24.903L1.37702 13H0.624023L4.62402 26H5.38702L10 14.095L14.614 26H15.377L19.377 
                13H18.623Z"
                    fill="black"
                  />
                </svg> </span
              >Total Workday : x days
            </p>
          </div>
        </cv-column>
        <cv-column :sm="4" :md="4" :lg="6">
          <h1>Impact environnemental</h1>
          <div class="resumeBox">
            <p>
              <span><Tree32 /></span>x % d’un arbre
            </p>
            <p>
              <span><HeatMap32 /></span>x g de CO2
            </p>
            <p>
              <span>
                <svg
                  width="30"
                  height="32"
                  viewBox="0 0 30 32"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M21.6421 31.038L21.0431 25.36H8.95207L8.35807 31.037L7.64207 30.963L8.22807 25.36H1.00007C0.855069 
                25.36 0.724069 25.273 0.668069 25.139C0.612069 25.005 0.642069 24.851 0.743069 24.747L7.98607 
                17.359H1.00007C0.859069 17.359 0.730069 17.276 0.672069 17.147C0.613069 17.019 0.636069 16.868 
                0.729069 16.762L10.0461 6.10101L5.31007 1.25101C5.20807 1.14801 5.17907 0.994015 5.23607 0.860015C5.29207 
                0.726015 5.42307 0.640015 5.56807 0.640015H14.9851H24.5291C24.6741 0.640015 24.8041 0.727015 24.8611 
                0.860015C24.9171 0.994015 24.8871 1.14801 24.7861 1.25201L19.9791 6.15501L29.2711 16.762C29.3651 16.868 
                29.3861 17.019 29.3291 17.148C29.2701 17.277 29.1421 17.36 29.0001 17.36H22.0441L29.2581 24.748C29.3591 
                24.852 29.3881 25.006 29.3321 25.14C29.2751 25.273 29.1451 25.36 29.0001 25.36H21.7681L22.3591 30.962L21.6421 
                31.038ZM21.6911 24.64H28.1451L21.0371 17.361H20.9241L21.6911 24.64ZM9.37307 24.64H20.6161L14.9841 17.578L9.37307 
                24.64ZM1.85707 24.64H8.30307L9.06407 17.361H8.99407L1.85707 24.64ZM15.7311 17.36L20.8801 23.817L20.2001 
                17.36H15.7311ZM9.78807 17.36L9.11407 23.808L14.2391 17.36H9.78807ZM21.3411 16.64H28.2061L19.8411 
                7.09101L20.7881 16.074L21.3411 16.64ZM14.9841 16.64H20.1241L20.0991 16.398L15.0281 11.205L9.88307 
                16.453L9.86307 16.64H14.9841ZM1.79307 16.64H8.69107L9.19307 16.128L10.1381 7.09101L1.79307 16.64ZM10.8761
                 6.95301L10.0031 15.302L14.5241 10.69L10.8761 6.95301ZM15.5321 10.691L19.9761 15.243L19.1121 7.04001L15.5321              
                10.691ZM11.3041 6.36001L15.0301 10.175L18.7701 6.36001H11.3041ZM11.4071 5.64001H18.5701L14.9851 1.54701L11.4071 
                5.64001ZM15.7781 1.36001L19.5031 5.61201L23.6711 1.36001H15.7781ZM6.42207 1.36001L10.5221 5.55901L14.1921 
                1.36001H6.42207Z"
                    fill="black"
                  />
                </svg> </span
              >L’équivalent d’une ampoule de 60W allumé pendant x heures.
            </p>
          </div>
        </cv-column>
      </cv-row>
      <div>
        <miner-table :columns="columns" :data="data" />
      </div>
    </cv-grid>
  </div>
</template>

<script>
import { Chip32, Tree32, HeatMap32 } from "@carbon/icons-vue";
import MinerTable from "@/components/MinerTable";

export default {
  name: "Miner",
  components: { Tree32, Chip32, HeatMap32, MinerTable },
  data: function () {
    return {
      searchText: "",
      columns: [
        "Miner type",
        "Power (W)",
        "Co2 footprint (g/kw)",
        "Running hours (h)",
        "Running days (day)",
        "Time up (day)",
      ],
      data: [
        ["GTX980", "73", "Transport", "24/24", "7/7", "568"],
        ["GTX980", "73", "Transport", "24/24", "7/7", "568"],
        ["GTX980", "73", "Transport", "24/24", "7/7", "568"],
      ],
    };
  },
};
</script>

<style lang="scss">
.minerVue {
  margin-top: 5rem;
  margin-left: 2rem;
  margin-right: 2rem;
}

.minerVue .cv-data-table {
  margin-top: 0rem;
}

.minerVue .cv-column h1 {
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: normal;
  font-size: 20px;
  line-height: 26px;
  text-align: left;
}

.minerVue .resumeBox {
  text-align: left;
  padding-left: 2rem;
  padding-top: 0.5rem;
  padding-right: 0.5rem;
  background-color: #f4f4f4;
  height: 100%;
}

.minerVue .resumeBox p {
  margin-bottom: 1.5rem;
}

.minerVue .resumeBox p span {
  padding-right: 1.5rem;
  position: relative;
  top: 0.7rem;
}

.minerVue .cv-row.bx--row {
  padding-bottom: 2rem;
}

.minerVue .cv-column {
  margin-bottom: 3rem;
}

/* tableau*/
</style>
