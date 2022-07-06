<template>
  <div class="benchmarkCompare">
    <section class="bx--table-toolbar">
      <div
        aria-label="Table Action Bar"
        class="bx--batch-actions bx--batch-actions--active"
      >
        <div class="bx--action-list">
          <button
            @click="cancel"
            class="
              cv-button
              bx--btn bx--btn--primary bx--btn--sm
              bx--batch-summary__cancel
            "
          >
            Cancel
          </button>
        </div>
        <div class="bx--batch-summary">
          <p class="bx--batch-summary__para">
            <span data-items-selected="">{{ data.length }} items selected</span>
          </p>
        </div>
      </div>
    </section>
    <cv-grid>
      <cv-row v-if="data.length === 2">
        <cv-column
          class="
            bx--col-sm-4 bx--col-md-4 bx--col-lg-6 bx--col-xlg-6 bx--col-max-6
          "
        >
          <benchmark-compare-elt :data="data[0]" :baseLine="data[1]" />
        </cv-column>
        <cv-column
          class="
            bx--col-sm-4 bx--col-md-4 bx--col-lg-6 bx--col-xlg-6 bx--col-max-6
          "
        >
          <benchmark-compare-elt :data="data[1]" :baseLine="data[0]" />
        </cv-column>
      </cv-row>

      <cv-row v-else>
        <cv-column
          class="
            bx--col-sm-4 bx--col-md-4 bx--col-lg-8 bx--col-xlg-8 bx--col-max-8
            test
          "
        >
          <benchmark-compare-avg :data="average" />
        </cv-column>
        <cv-column
          v-for="(item, index) in data"
          :key="index"
          class="
            bx--col-sm-4 bx--col-md-4 bx--col-lg-6 bx--col-xlg-6 bx--col-max-6
          "
        >
          <benchmark-compare-elt :data="item" :baseLine="average" />
        </cv-column>
      </cv-row>
    </cv-grid>
  </div>
</template>

<script>
import BenchmarkCompareElt from "../components/BenchmarkCompareElt.vue";
import BenchmarkCompareAvg from "../components/BenchmarkCompareAvg.vue";

export default {
  name: "BenchmarkCompareView",
  components: { BenchmarkCompareElt, BenchmarkCompareAvg },
  props: {
    data: Array,
  },
  data: function () {
    return {};
  },
  methods: {
    cancel() {
      this.$emit("cancel");
    },
  },
  computed: {
    average() {
      let res = ["Average", "Average", "Average", 0, 0];
      this.data.forEach((e) => {
        res[3] += e[3];
        res[4] += e[4];
      });
      res[3] /= this.data.length;
      res[4] /= this.data.length;
      console.log(res);
      return res;
    },
  },
};
</script>

<style lang="scss">
.benchmarkCompare .bx--data-table-header {
  background-color: white !important;
}

.benchmarkCompare .cv-column.bx--col {
  padding-left: 0;
  padding-right: 0;
}

div.benchmarkCompare div.cv-column.bx--col {
  border: 1px solid #e0e0e0;
  height: auto;
}

.benchmarkCompare .bx--table-toolbar {
  margin-top: 2rem;
}

.benchmarkCompare .cv-grid.bx--grid {
  padding-right: 0;
  padding-left: 0;
  margin-right: 0;
  margin-left: 0;
  max-width: none;
}

.benchmarkCompare .bx--row {
  margin-right: 0;
  margin-left: 0;
}

.benchmarkCompare .cv-data-table {
  margin-top: 0;
}

.benchmarkCompare table.bx--data-table thead {
  display: none;
}

.benchmarkCompare div.cv-data-table .cv-data-table-row-inner.cv-data-table-row {
  height: 4rem;
}

.benchmarkCompare .bx--data-table-header {
  margin-top: 0.75rem;
  margin-bottom: 0.75rem;
}

@media (max-width: 695px) {
  .benchmarkCompare .bx--batch-summary .bx--batch-summary__para span.right {
    display: block;
    margin-left: 0;
  }
}

.benchmarkCompare .test {
  margin: 0 auto;
}
</style>
