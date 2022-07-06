<template>
  <div class="minerTable">
    <!-- <cv-loading
      v-if="loading"
      :active="loading"
      :overlay="loading"
    ></cv-loading> -->

    <!-- <cv-data-table-skeleton
      v-if="loading"
      :columns="columns"
      :rows="10"
      :expandingSearch="false"
      @search="onSearch"
      :pagination="{ numberOfItems: 10, pageSizes: [10] }"
    >
      <template slot="batch-actions">
        <cv-button></cv-button>
      </template>
    </cv-data-table-skeleton> -->

    <cv-modal
      :visible="visible"
      @modal-hidden="modalHidden"
      @modal-shown="actionShown"
      @modal-hide-request="actionHideRequest"
      @after-modal-hidden="actionAfterHidden"
      @primary-click="actionPrimary"
      :auto-hide-off="autoHideOff"
      size="small"
    >
      <template slot="label">Modal for miner adding</template>
      <template slot="title">Add a miner</template>
      <template slot="content" class="content">
        <div class="left-align">
          <div class="bx--form-item">
            <label for="text-input-3h9mddk235a" class="bx--label"
              >Miner type</label
            >
            <input
              id=""
              type="text"
              class="bx--text-input"
              placeholder="Write the type of mine"
              data-modal-primary-focus
            />
          </div>
          <label class="bx--label">Hours per day</label>
          <cv-dropdown
            :light="light"
            :placeholder="placeholder"
            :value="value"
            :up="up"
            :inline="inline"
          >
            <cv-dropdown-item value="24"><span>24</span></cv-dropdown-item>
            <cv-dropdown-item value="12">12</cv-dropdown-item>
          </cv-dropdown>
          <label class="bx--label">Days up in a week</label>
        </div>

        <div class="radioContent">
          <cv-radio-group :vertical="vertical">
            <cv-radio-button
              name="group-1"
              label="1"
              value="value-1"
              :checked="checked1"
              :hide-label="hideLabel"
              :label-left="labelLeft"
            />
            <cv-radio-button
              name="group-1"
              label="2"
              value="value-2"
              :disabled="disabled2"
              :hide-label="hideLabel"
              :label-left="labelLeft"
            />
            <cv-radio-button
              name="group-1"
              label="3"
              value="value-2"
              :disabled="disabled2"
              :hide-label="hideLabel"
              :label-left="labelLeft"
            />
            <cv-radio-button
              name="group-1"
              label="4"
              value="value-2"
              :disabled="disabled2"
              :hide-label="hideLabel"
              :label-left="labelLeft"
            />
            <cv-radio-button
              name="group-1"
              label="5"
              value="value-2"
              :disabled="disabled2"
              :hide-label="hideLabel"
              :label-left="labelLeft"
            />
            <cv-radio-button
              name="group-1"
              label="6"
              value="value-2"
              :disabled="disabled2"
              :hide-label="hideLabel"
              :label-left="labelLeft"
            />
            <cv-radio-button
              name="group-1"
              label="7"
              value="value-2"
              :disabled="disabled2"
              :hide-label="hideLabel"
              :label-left="labelLeft"
            />
          </cv-radio-group>
        </div>
      </template>
      <template slot="secondary-button">Cancel</template>
      <template slot="primary-button" v-if="use_primaryButton"
        >Add a miner</template
      >
    </cv-modal>

    <cv-data-table
      :columns="columns"
      @search="onSearch"
      :data="data"
      title="Mining farm name"
      helperText="A list of your miners"
      :expandingSearch="false"
    >
      <template slot="actions">
        <cv-button small @click="showModelAddMiner"
          >Add Miner <Add20
        /></cv-button>
      </template>
    </cv-data-table>

    <cv-toast-notification
      v-if="notifySuccess"
      kind="success"
      :title="title"
      :sub-title="subTitle"
      :caption="caption"
      @close="doClose"
      :low-contrast="lowContrast"
      :hide-close-button="hideCloseButton"
    >
    </cv-toast-notification>
  </div>
</template>

<script>
import { Add20 } from "@carbon/icons-vue";

export default {
  name: "MinerTable",
  components: { Add20 },
  props: {
    columns: Array,
    data: Array,
    loading: Boolean,
    totalRows: Number,
    pageStart: Number,
  },
  methods: {
    onSearch($event) {
      this.$emit("search", $event);
    },
    showModelAddMiner() {
      this.visible = true;
    },
    modalHidden() {
      this.visible = false;
    },
    addMiner() {
      this.notifySuccess = true;
    },
    actionPrimary() {
      this.visible = false;
      this.notifySuccess = true;
    },
    doClose() {
      this.notifySuccess = false;
    },
  },
  data: function () {
    return {
      title: "New miner",
      subTitle: "New miner correctely add.",
      caption: " 15:36:01 AM",
      visible: false,
      notifySuccess: false,
      use_primaryButton: true,
    };
  },
  mounted: function () {
    if (!this.loading) {
      this.$nextTick(function () {
        // Uncheck "select all" checkbox in the table header
        let checkbox = document.querySelector(
          ".cv-checkbox.bx--checkbox-wrapper input"
        );
        checkbox.checked = false;
        checkbox.setAttribute("aria-checked", false);
        document.querySelector(
          "th.bx--table-column-checkbox > div:nth-child(1) > label:nth-child(2)"
        ).dataset.containedCheckboxState = false;
      });
    }
  },
};
</script>

<style lang="scss">
.minerTable .bx--action-list > button:nth-child(1) > svg:nth-child(1) {
  margin-left: 0.5rem;
}

.minerTable .bx--data-table-header {
  text-align: left;
}

.minerTable .bx--toolbar-content {
  background-color: #f4f4f4;
}
.minerTable .bx--data-table tbody tr.selectedRow td {
  background-color: #e0e0e0;
}

.minerTable
  table.bx--data-table.bx--skeleton
  tr
  div.cv-checkbox.bx--checkbox-wrapper
  label.bx--checkbox-label
  span.bx--checkbox-label-text {
  display: none;
}

@media (max-width: 41.98rem) {
  .minerTable .bx--pagination__left .cv-select {
    display: flex;
  }
  .minerTable .bx--pagination__right {
    display: flex;
  }

  .minerTable button.bx--pagination__button:nth-child(3),
  .minerTable button.bx--pagination__button:nth-child(4) {
    display: block;
  }
}

.minerVue .bx--modal-header {
  text-align: left !important;
}

.minerVue .bx--modal-content {
  padding-right: 1rem;
}

.minerVue .bx--modal-content .bx--form-item {
  margin-bottom: 3rem;
}

.minerVue .bx--modal-content .left-align {
  text-align: left;
}

.radioContent {
  display: inline-block;
}

.minerVue .bx--toast-notification {
  position: fixed;
  right: 0;
  bottom: 0;
  margin: 60px 10px;
  height: 7rem;
  text-align: left;
}
</style>
