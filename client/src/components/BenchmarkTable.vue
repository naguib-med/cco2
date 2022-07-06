<template>
  <div>
    <cv-loading
      v-if="loading"
      :active="loading"
      :overlay="loading"
    ></cv-loading>

    <cv-data-table-skeleton
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
    </cv-data-table-skeleton>

    <cv-data-table
      v-else
      :columns="columns"
      :sortable="true"
      :pagination="{ numberOfItems: this.totalRows, pageSizes: this.pageSizes }"
      @pagination="onPaginationChange"
      @sort="onSort"
      @search="onSearch"
      :data="data"
      :expandingSearch="false"
      batch-cancel-label="Cancel"
      ref="dataTable"
      v-on:row-select-changes="actionRowSelectChanges"
    >
      <template slot="batch-actions">
        <cv-button @click="onCompare"> Compare selection <Add20 /></cv-button>
      </template>
    </cv-data-table>
  </div>
</template>

<script>
import { Add20 } from "@carbon/icons-vue";

export default {
  name: "BenchmarkTable",
  components: { Add20 },
  props: {
    columns: Array,
    data: Array,
    loading: Boolean,
    totalRows: Number,
    pageStart: Number,
  },
  methods: {
    actionRowSelectChanges(val) {
      this.selectedRows = val.map((i) => Number(i) + this.pageStart);
      this.$emit("row-select-changes", this.selectedRows);
    },
    onCompare() {
      this.$emit("compare");
    },
    deSelectAllRows() {
      this.$refs.dataTable.deselect();
    },
    onPaginationChange($event) {
      if (this.selectedRows.length != 0) this.deSelectAllRows();
      this.$emit("pagination", $event);
    },
    onSort($event) {
      if (this.selectedRows.length != 0) this.deSelectAllRows();
      this.$emit("sort", $event);
    },
    onSearch($event) {
      this.$emit("search", $event);
    },
    log(val) {
      console.log(val);
    },
  },
  data: function () {
    return {
      selectedRows: [],
      use_initialSearchSlot: false,
      sampleOverflowMenu: [],
      use_batchActions: true,
      pageSizes: [
        5,
        {
          value: 10,
          selected: true,
        },
        15,
        20,
        50,
      ],
    };
  },
};
</script>

<style lang="scss">
.bx--action-list > button:nth-child(1) > svg:nth-child(1) {
  margin-left: 0.5rem;
}

.bx--table-toolbar {
  background-color: #fff;
}

.bx--data-table tbody tr.selectedRow td {
  background-color: #e0e0e0;
}

table.bx--data-table.bx--skeleton
  tr
  div.cv-checkbox.bx--checkbox-wrapper
  label.bx--checkbox-label
  span.bx--checkbox-label-text {
  display: none;
}

@media (max-width: 41.98rem) {
  .bx--pagination__left .cv-select {
    display: flex;
  }
  .bx--pagination__right {
    display: flex;
  }

  button.bx--pagination__button:nth-child(3),
  button.bx--pagination__button:nth-child(4) {
    display: block;
  }
}
</style>
