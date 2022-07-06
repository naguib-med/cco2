<template>
  <cv-header aria-label="Carbon header">
    <cv-skip-to-content href="#main-content">
      Skip to content
    </cv-skip-to-content>
    <cv-header-name href="javascript:void(0)" prefix="">
      &nbsp;[CCo2]
    </cv-header-name>

    <template slot="header-global">
      <cv-header-global-action
        aria-label="User avatar"
        @click="actionUserAvatar"
        aria-controls="user-panel"
        v-if="$store.getters.token !== ''"
      >
        <User20 />
      </cv-header-global-action>
    </template>

    <cv-header-menu-button aria-label="Header menu" aria-controls="side-nav" />

    <template slot="left-panels">
      <cv-side-nav id="side-nav">
        <cv-side-nav-items>
          <cv-side-nav-menu title="All about CCo2">
            <cv-side-nav-menu-item to="/what">
              What is CCo2
            </cv-side-nav-menu-item>

            <cv-side-nav-menu-item to="/who">
              Who uses CCo2
            </cv-side-nav-menu-item>

            <cv-side-nav-menu-item to="/ecosystem">
              The CCo2 ecosystem
            </cv-side-nav-menu-item>

            <cv-side-nav-menu-item to="/team">
              The CCo2 team
            </cv-side-nav-menu-item>
          </cv-side-nav-menu>

          <cv-side-nav-link to="/benchmark">Benchmark </cv-side-nav-link>
          <cv-side-nav-link to="/miner">Miners </cv-side-nav-link>

          <hr class="divider" />
          <cv-side-nav-link to="/account"> Account </cv-side-nav-link>

          <hr class="divider" />
          <li class="cv-side-nav-menu bx--side-nav__item">
            <a
              target="_blank"
              rel="noopener noreferrer"
              href="https://forge.univ-lyon1.fr/groupe-11-projet-trans/projet"
              class="cv-side-nav-item-link bx--side-nav__link"
            >
              <span class="bx--side-nav__submenu-title">GitHub</span>
              <div
                class="
                  bx--side-nav__icon
                  bx--side-nav__icon--small
                  bx--side-nav__submenu-chevron
                "
                aria-label="expand nav menu"
              >
                <svg
                  focusable="false"
                  preserveAspectRatio="xMidYMid meet"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="currentColor"
                  width="16"
                  height="16"
                  viewBox="0 0 16 16"
                  aria-hidden="true"
                >
                  <path
                    d="M13,14H3c-0.6,0-1-0.4-1-1V3c0-0.6,0.4-1,1-1h5v1H3v10h10V8h1v5C14,13.6,13.6,14,13,14z"
                  ></path>
                  <path
                    d="M10 1L10 2 13.3 2 9 6.3 9.7 7 14 2.7 14 6 15 6 15 1z"
                  ></path>
                </svg>
              </div>
            </a>
          </li>
        </cv-side-nav-items>
      </cv-side-nav>
    </template>
  </cv-header>
</template>

<script>
import { User20 } from "@carbon/icons-vue";

export default {
  name: "AppHeader",
  components: { User20 },
  methods: {
    actionUserAvatar() {
      this.$store.commit("updateToken", "");
    },
  },
};
</script>

<style lang="scss">
.cv-side-nav-items {
  background: #161616;
}

span.bx--side-nav__submenu-title,
span.bx--side-nav__link-text {
  color: #c6c6c6 !important;
}

.bx--side-nav__icon > svg,
.cv-side-nav-menu__chevron-svg {
  fill: #c6c6c6 !important;
}

hr.divider {
  border-color: #393939;
  margin: 0.5rem 1rem;
}

.bx--side-nav__link:hover,
.bx--side-nav__submenu:hover,
a.bx--side-nav__link--current,
.bx--side-nav__item .router-link-exact-active,
.bx--side-nav__item .router-link-active {
  background: #303030 !important;
}

#user-pannel {
  display: none;
}
</style>
