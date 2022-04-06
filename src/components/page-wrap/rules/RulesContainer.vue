<template>
  <div class="container mx-auto">
    <div class="px-6 md:px-10 lg:px-20">
      <div class="pt-10 pb-24">
        <div class="text-5xl text-white font-bold text-center">Rules</div>
        <div class="max-w-2xl mx-auto text-center text-gray-500 mt-5">
          <p class="mb-2">Welcome to the Origin Realms rules page! This page is designed to make understanding our rules simple and easy. Rules are expected to be followed by all users, regardless of their rank or time played on the server.</p>
          <p class="mb-2">As the owner of your Minecraft account, you are responsible for what happens while you are logged onto Origin Realms. If a rule is broken during your time online you'll be punished accordingly, just like everyone else. </p>
          <p>Our staff team works incredibly hard to keep Origin Realms safe and enjoyable for everyone. If you find yourself being warned by a member of our team, you are expected to respect their decision and work with them to resolve the situation.</p>
        </div>
      </div>
      <div class="content pb-20">
        <section v-for="(rule, index) in rules" :key="index" class="pb-10">
          <div class="heading pb-6">
            <div class="title font-bold text-white text-xl mb-2">{{ rule.title }}</div>
            <div class="description text-gray-600 text-sm">{{ rule.description }}</div>
          </div>
          <div class="rules">
            <ul class="text-lg text-gray-400">
              <li v-for="(detail, index) in rule.content" class="bg-gray-900 rounded-md py-4 px-4 mb-4">
                <div class="top flex items-center">
                  <div class="num bg-gray-800 rounded-full font-bold text-sm w-8 h-8 flex items-center justify-center">{{ index + 1 }}</div>
                  <span class="block text-gray-300 font-bold ml-4">{{ detail }}</span>
                </div>
              </li>
            </ul>
          </div>
        </section>
      </div>
    </div>
  </div>
</template>

<script setup>
const rules = [
  {
    title: 'Inappropriate Chat Conduct',
    description: 'The way users conduct themselves in our chat is incredibly important, as Origin Realms aims to be a friendly place for players of all ages. Below are examples of the kind of conduct that will result in a punishment',
    content: [
      'Disrespectful/offensive language and hate speech.',
      'Racism and Discrimination.',
      'Intentionally avoiding the chat filter.',
      'Spamming or rioting of any kind.',
      'Harassing and abusing others.',
      'Sharing personal information regarding others.',
      'Advertising other servers or IP\'s.'
    ]
  },
  {
    title: 'Inappropriate Activities',
    description: 'We expect our users to behave in an appropriate and respectful manner at all times. Origin Realms is designed to be a non-competitive casual game, not a place to cause havoc. Below are examples of behaviour that will result in a punishment, and remember; your account is your responsibility!',
    content: [
      'Intentionally griefing other users land.',
      'Intentionally attempting to kill someone outside of PVP areas.',
      'Scamming other users via trades etc.',
      'Inappropriate buildings or symbols.',
      'Inappropriate account names and skins.',
      'Evading punishment by using alternate accounts.',
      'Advertising and trading in-game items for real money and vice versa.'
    ]
  },
  {
    title: 'Modifications & Exploits',
    description: 'Origin Realms does not permit the use of any clients or modifications that provide an unfair advantage. If a mod gives you an unfair advantage over other players, simply don\'t use it. If you are caught exploiting any bugs with the base game or our own systems, you will also be punished instantly.',
    content: [
      'X-ray resource packs/modifications.',
      'Non-cosmetic software.',
      'Hacked clients.',
      'Auto-clicking (including putting weight on a key and AFKing).',
      'Vanilla Minecraft exploits.',
      'Duplicating items in any way shape or form.',
      'Clearly unintentional bugs with our custom systems.'
    ]
  }
]
</script>

<script>
export default {
  name: "RulesContainer"
}
</script>