<template>
  <suspense>
    <div class="absolute grid h-5/6 w-3/4">
      <login-page/>
    </div>
    <template #fallback>
      <page-loading/>
    </template>
  </suspense>
</template>

<script>
import {defineAsyncComponent} from "vue";
import PageLoading from "../components/PageLoading.vue";

const loginPage = defineAsyncComponent({
  loader: () => import('../components/routes/LoginRoute/LoginPage.vue')
})

export default {
  name: "LoginRoute",
  components: {PageLoading, loginPage}
}
</script>

<script setup>

</script>