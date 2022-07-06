<template>
  <cv-data-table title="Average">
    <template slot="data">
      <cv-data-table-row>
        <cv-data-table-cell>
          <p class="">
            The values are all compared to the average of all of the selected
            values
          </p>
        </cv-data-table-cell>
        <cv-data-table-cell></cv-data-table-cell>
      </cv-data-table-row>
      <cv-data-table-row>
        <cv-data-table-cell>
          <p>Power (W)</p>
        </cv-data-table-cell>
        <cv-data-table-cell>
          {{ data[3] }}
        </cv-data-table-cell>
      </cv-data-table-row>
      <cv-data-table-row>
        <cv-data-table-cell>
          <p>Estimated Revenue</p>
        </cv-data-table-cell>
        <cv-data-table-cell>
          {{ data[4] }}
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

.benchmarkCompare .centered {
  text-align: center;
}
</style>
