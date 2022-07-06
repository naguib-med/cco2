<template>
  <div class="benchmark">
    <h1 class="benchmark-title">Benchmark</h1>
    <h2 class="benchmark-subtitle">Compare crypto miners</h2>

    <!-- Benchmark table listing -->
    <benchmark-table
      v-if="!comparing"
      :columns="columns"
      :data="pagedRows"
      :totalRows="filteredData.length"
      @pagination="onPagination"
      :loading="isLoading"
      :pageStart="pageStart"
      @row-select-changes="onRowSelectChanges"
      @sort="onSort"
      @search="onSearch"
      @compare="onCompare"
    />
    <cv-toast-notification
      v-if="notifyError && !comparing"
      kind="error"
      title="Selection Error"
      sub-title="You need to select more miners to compare them!"
      @close="notifyError = false"
    ></cv-toast-notification>

    <!-- Comparison view -->
    <benchmark-compare-view
      v-if="comparing"
      @cancel="onCompareCancel"
      :data="selectedData"
    />
  </div>
</template>

<script>
import BenchmarkTable from "@/components/BenchmarkTable";
import BenchmarkCompareView from "../components/BenchmarkCompareView.vue";

export default {
  name: "Benchmark",
  components: { BenchmarkTable, BenchmarkCompareView },
  data: function () {
    return {
      urlBenchmark: "https://192.168.74.198/api/test",
      comparing: false,
      notifyError: false,
      isLoading: true,
      pageSize: 0,
      pageStart: 0,
      indexSorted: 0,
      sortOrder: "none",
      searchText: "",
      selectedRows: [],
      columns: [
        "Manufacturer",
        "Model",
        "Currency",
        "Power Consumption",
        "Estimated Revenue",
      ],
      data: [],
    };
  },
  computed: {
    selectedData() {
      let array = new Array();
      this.selectedRows.forEach((i) => {
        array.push(this.sortedData[i]);
      });
      return array;
    },
    pagedRows() {
      return this.sortedData.slice(
        this.pageStart,
        this.pageStart + this.pageSize
      );
    },
    sortedData() {
      switch (this.sortOrder) {
        case "ascending":
          return this.filteredData.slice(0).sort((e1, e2) => {
            if (e1[this.indexSorted] < e2[this.indexSorted]) return -1;
            else if (e1[this.indexSorted] > e2[this.indexSorted]) return 1;
            else return 0;
          });

        case "descending":
          return this.filteredData.slice(0).sort((e1, e2) => {
            if (e1[this.indexSorted] > e2[this.indexSorted]) return -1;
            else if (e1[this.indexSorted] < e2[this.indexSorted]) return 1;
            else return 0;
          });

        case "none":
        default:
          return this.filteredData;
      }
    },
    filteredData() {
      if (this.searchText === "") return this.data;
      return this.data.filter((e) => {
        return e.reduce(
          (prev, cur) =>
            prev ||
            (typeof cur === "string" ? cur.includes(this.searchText) : false),
          false
        );
      });
    },
  },
  methods: {
    onPagination(val) {
      this.pageSize = val.length;
      this.pageStart = val.start - 1;
    },
    onRowSelectChanges(val) {
      // val contains the indexes of the elements in sortedData that are selected
      this.selectedRows = val;
      console.log(val);
    },
    onSort(val) {
      this.indexSorted = Number(val.index);
      this.sortOrder = val.order;
    },
    onSearch(search) {
      this.searchText = search;
    },
    onCompare() {
      if (this.selectedRows.length < 2) this.notifyError = true;
      else this.comparing = true;
    },
    onCompareCancel() {
      this.comparing = false;
    },
  },
  mounted() {
    fetch(this.urlBenchmark, { method: "GET" })
      .then((response) => {
        console.log(response);
        return response.json();
      })
      .then((data) => {
        let res = [];
        data.forEach((elt) => {
          let a = [];
          a.push(elt.manufacter);
          a.push(elt.model);
          a.push(elt.currency);
          a.push(elt.power_consumption);
          a.push(elt.revenue_month_electricity_deducted);
          res.push(a);
        });
        this.data = res;
        this.isLoading = false;

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
      });
  },
};
</script>

<style lang="scss">
.benchmark {
  padding-top: 1rem;
}

.benchmark h1,
.benchmark h2 {
  padding-left: 1rem;
}

.benchmark-title {
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: normal;
  font-size: 20px;
  line-height: 26px;
  color: #161616;
  text-align: left;
}

.benchmark-subtitle {
  font-family: IBM Plex Sans;
  font-style: normal;
  font-weight: normal;
  font-size: 14px;
  line-height: 18px;
  color: #393939;
  text-align: left;
}

.cv-data-table {
  margin-top: 2rem;
}

.benchmark .bx--toast-notification {
  position: fixed;
  right: 0;
  bottom: 0;
  margin: 60px 10px;
  height: 5rem;
  padding-bottom: 5.5rem;
}
</style>
