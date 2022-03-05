<template>
  <section id="confirm">
    <h4 class="font-bold text-white text-xl mb-6">Privacy & Terms</h4>
    <div class="grid lg:grid-cols-2 gap-6">
      <tiny-privacy/>
      <tiny-terms/>
    </div>
  </section>
</template>

<script setup>

</script>

<script>
import TinyPrivacy from "./rule/TinyPrivacy.vue";
import TinyTerms from "./rule/TinyTerm.vue";
export default {
  name: "RuleInformation",
  components: {TinyTerms, TinyPrivacy}
}
</script>