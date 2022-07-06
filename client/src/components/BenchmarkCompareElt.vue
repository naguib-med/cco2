<template>
  <cv-data-table :title="data[1]">
    <template slot="data">
      <cv-data-table-row>
        <cv-data-table-cell>
          <p>Manufacturer</p>
        </cv-data-table-cell>
        <cv-data-table-cell> {{ data[0] }} </cv-data-table-cell>
      </cv-data-table-row>
      <cv-data-table-row>
        <cv-data-table-cell>
          <p>Currency</p>
        </cv-data-table-cell>
        <cv-data-table-cell> {{ data[2] }} </cv-data-table-cell>
      </cv-data-table-row>
      <cv-data-table-row>
        <cv-data-table-cell>
          <p>Power (W)</p>
        </cv-data-table-cell>
        <cv-data-table-cell :class="power < 0 ? 'green' : 'red'">
          {{ power &lt; 0 ? "-" : "+" }} {{ Math.abs(power) }}
        </cv-data-table-cell>
      </cv-data-table-row>
      <cv-data-table-row>
        <cv-data-table-cell>
          <p>Estimated Revenue</p>
        </cv-data-table-cell>
        <cv-data-table-cell :class="revenue < 0 ? 'red' : 'green'">
          {{ revenue &lt; 0 ? "-" : "+" }} {{ Math.abs(revenue) }}
        </cv-data-table-cell>
      </cv-data-table-row>
    </template>
  </cv-data-table>
</template>

<script>
export default {
  name: "BenchmarkCompareElt",
  props: {
    data: Array,
    baseLine: Array,
  },
  computed: {
    power() {
      return this.data[3] - this.baseLine[3];
    },
    revenue() {
      return this.data[4] - this.baseLine[4];
    },
  },
};
</script>

<style lang="scss">
.benchmarkCompare .cv-data-table-row-inner.cv-data-table-row {
  background-color: #ffffff !important;
}

.benchmarkCompare .cv-data-table-row-inner.cv-data-table-row td {
  background-color: #ffffff !important;
}

div.benchmarkCompare tr.cv-data-table-row-inner.cv-data-table-row td {
  border-top: 1px solid #e0e0e0;
}

.benchmarkCompare .cv-data-table-row-inner.cv-data-table-row td.green {
  background-color: #198038 !important;
  border-top: 1px solid rgb(111, 111, 111);
  border-bottom: 1px solid rgb(111, 111, 111);
  color: white;
  text-align: center;
  font-size: 1.5rem;
}

.benchmarkCompare .cv-data-table-row-inner.cv-data-table-row td.red {
  background-color: #da1e28 !important;
  border-top: 1px solid rgb(111, 111, 111);
  border-bottom: 1px solid rgb(111, 111, 111);
  color: white;
  text-align: center;
  font-size: 1.5rem;
}
</style>
