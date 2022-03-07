<template>
  <section id="buttons" class="relative">
    <form method="post" action="checkout/pay" id="checkoutForm">
      <div class="hidden"><input type="hidden" name="type" value="single"><input type="radio" id="gateway-600346"
                                                                                 name="gateway"
                                                                                 class="absolute opacity-0"
                                                                                 value="600346"><input
          name="privacyConsent" type="checkbox" value="1"><input name="agreement" type="checkbox" value="true"><input
          name="email" type="text"><input name="paypalv2-order-id"><input name="paypalv2-payer-id"><input
          name="paypalv2-agreement-token"><input type="hidden" name="paypalv2-personal-account"
                                                 value="postObject['paypalv2-personal-account']"></div>
      <div class="group">
        <div
            class="popup absolute top-0 right-0 text-gray-500 bg-black-80 rounded-lg text-sm font-normal max-w-md py-1 px-2 text-right pointer-events-none opacity-0 transition-opacity duration-150 ease-in-out group-hover:opacity-100">
          Please enter your email and agree to the terms &amp; privacy policy to pay.
        </div>
        <div
            class="buttons text-right mt-12 transition-opacity duration-150 ease-in-out pointer-events-none select-none opacity-50">
          <button
              class="inline-flex items-center py-3 px-5 bg-btn border border-lighten shadow-btn uppercase font-extrabold tracking-widest text-btn-text transition-all duration-150 ease-in-out hover:opacity-75 focus:outline-none hidden"
              type="submit"><span>Purchase</span>
            <svg class="w-5 h-5 ml-2" fill="currentColor" viewBox="0 0 20 20">
              <path fill-rule="evenodd"
                    d="M12.293 5.293a1 1 0 011.414 0l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-2.293-2.293a1 1 0 010-1.414z"
                    clip-rule="evenodd"></path>
            </svg>
          </button>
          <div id="paypal-button" class="text-center lg:text-right">
            <div id="zoid-paypal-button-b6dd1adcab"
                 class="paypal-button paypal-button-context-iframe paypal-button-label-paypal paypal-button-size-medium paypal-button-layout-vertical"
                 data-paypal-smart-button-version="4.0.334" style="height: 116px;">

              <div class="zoid-outlet" style="height: 116px; transition: all 0.5s ease-in-out 0.3s;">
                <!--<iframe class="zoid-component-frame zoid-visible" frameborder="0" allowtransparency="true"-->
                <!--        name="xcomponent__ppbutton__4__pmrhk2leei5cemdggnqtazlfmvtdiirmej2gczzchirhaylzobqwyllcov2hi33oeiwcey3pnvyg63tfnz2faylsmvxhiir2pmrhezlgei5ce5dpoarh2lbcojsw4zdfojigc4tfnz2ceot3ejzgkzrchirhi33qej6syitqojxxa4zchj5se5dzobsseorcojqxoirmej3gc3dvmurdu6zcmvxhmir2ejyhe33eovrxi2lpnyrcyitdn5ww22luei5hi4tvmuwce43upfwgkir2pmrgyylzn52xiir2ej3gk4tunfrwc3bcfqrhg2l2murduitnmvsgs5lneiwce43imfygkir2ejzgky3ueiwcey3pnrxxeir2ejtw63deeiwce3dbmjswyir2ejygc6lqmfwce7jmejthk3tenfxgoir2pmrgc3dmn53wkzbchjnsey3bojscelbcozsw43lpejosyitenfzwc3dmn53wkzbchjnse5tfnzww6is5fqrhezlnmvwwezlsmvsceos3ejygc6lqmfwcexjmejzgk3lfnvrgk4rchj5sex27or4xazk7l4rduis7l5thk3tdoruw63s7l4rh27jmejygc6lnmvxhiir2pmrf6x3upfygkx27ei5cex27mz2w4y3unfxw4x27ej6syitpnzaxk5din5zgs6tfei5hwis7l52hs4dfl5pseorcl5pwm5lomn2gs33ol5pse7jmejxw4rlsojxxeir2pmrf6x3upfygkx27ei5cex27mz2w4y3unfxw4x27ej6syiten5wwc2loei5ce43un5zgkltpojuwo2loojswc3dnomxgg33neiwce43fonzws33ojfcceorcovuwix3bmeydozdfmu3ggok7nv2hsntnmrstm3tem4rcyitcov2hi33oknsxg43jn5xesrbchirhk2lel5sdqodbguygiztdgnpw25dzgzwwi3jwnz2gcirmejzgk3temvzgkzccov2hi33oomrduitqmf4xaylmfr3gk3tnn4wgg4tfmruxilddmfzgiirmejzxi33smftwkskeei5ce5ljmrptknjug42toy3cme3v63lume3g25dbgzwxiyzcfqrg2zlumerdu635fqrgk3tbmjwgkttboruxmzkdnbswg23pov2ceotgmfwhgzjmejrwy2lfnz2ceot3puwce43povzggzjchirg2yloovqwyirmejyhezlgmv2gg2cmn5tws3rchjtgc3dtmuwce5lqmrqxizkdnruwk3tuinxw4ztjm52xeylunfxw4ir2orzhkzjmejrwqzldnnxxk5cvojuseotoovwgylbcmf2xi2cdn5sgkir2eircyitpnzjgk3temvzceot3ejpv65dzobsv6xzchirf6x3govxgg5djn5xf6xzcpuwce33oinqw4y3fnqrdu6zcl5pxi6lqmvpv6ir2ejpv6ztvnzrxi2lpnzpv6it5fqrg63sdnruwg2zchj5sex27or4xazk7l4rduis7l5thk3tdoruw63s7l4rh2lbcn5xfezltnf5gkir2pmrf6x3upfygkx27ei5cex27mz2w4y3unfxw4x27ej6syitmn5rwc3dfei5ce6til5bu4irmejwg6z2mmv3gk3bchirhoylsnyrcyitbo5qws5cqn5yhk4ccojuwiz3fei5hwis7l52hs4dfl5pseorcl5pwm5lomn2gs33ol5pse7jmejtwk5cqmftwkvlsnqrdu6zcl5pxi6lqmvpv6ir2ejpv6ztvnzrxi2lpnzpv6it5fqrhizltoqrdu6zcmfrxi2lpnyrduitdnbswg23pov2ce7jmej2wszbchirgentemqywczddmfrcelbcozsxe43jn5xceorcgqrh27jmejrwq2lmmrcg63lbnfxceorcnb2hi4dthixs653xo4xhaylzobqwyltdn5wselbcnfsceorcmqzdayryguytenldeiwcezdpnvqws3rchirgq5duobztulzpon2g64tffzxxe2lhnfxhezlbnrwxgltdn5wse7i__"-->
                <!--        title="PayPal" scrolling="no" allowpaymentrequest="allowpaymentrequest"-->
                <!--        src="https://www.paypal.com/smart/button?env=production&amp;commit=true&amp;style.layout=vertical&amp;style.size=medium&amp;style.shape=rect&amp;style.color=gold&amp;style.label=paypal&amp;funding.allowed=card%2Cvenmo&amp;funding.disallowed=venmo&amp;funding.remembered=paypal&amp;domain=store.originrealms.com&amp;sessionID=uid_aa07dee6c9_mty6mde6ndg&amp;buttonSessionID=uid_d88a50dfc3_mty6mdm6nta&amp;renderedButtons=paypal%2Cvenmo%2Ccredit%2Ccard&amp;storageID=uid_554757cba7_mta6mta6mtc&amp;locale.x=zh_CN&amp;logLevel=warn&amp;sdkMeta=eyJ1cmwiOiJodHRwczovL3d3dy5wYXlwYWxvYmplY3RzLmNvbS9hcGkvY2hlY2tvdXQuanMifQ&amp;uid=b6dd1adcab&amp;version=4&amp;xcomponent=1"-->
                <!--        style="background-color: transparent;"></iframe>-->
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  </section>
</template>

<script>
export default {
  name: "checkoutbuttons"
}
</script>

<style scoped>
#zoid-paypal-button-b6dd1adcab {
  font-size: 0;
  width: 100%;
  overflow: hidden;
  min-width: 200px;
}

#zoid-paypal-button-b6dd1adcab.paypal-button-size-responsive {
  text-align: center;
}

#zoid-paypal-button-b6dd1adcab > .zoid-outlet {
  display: inline-block;
  min-width: 200px;
  max-width: 750px;
  position: relative;
}

#zoid-paypal-button-b6dd1adcab.paypal-button-layout-vertical > .zoid-outlet {
  min-width: 200px;
}

#zoid-paypal-button-b6dd1adcab > .zoid-outlet {
  width: 250px;
  height: 35px;
}

#zoid-paypal-button-b6dd1adcab.paypal-button-size-responsive > .zoid-outlet {
  width: 100%;
}

#zoid-paypal-button-b6dd1adcab > .zoid-outlet > iframe {
  min-width: 100%;
  max-width: 100%;
  width: 200px;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

#zoid-paypal-button-b6dd1adcab > .zoid-outlet > iframe.zoid-component-frame {
  z-index: 100;
}

#zoid-paypal-button-b6dd1adcab > .zoid-outlet > iframe.zoid-prerender-frame {
  transition: opacity .2s linear;
  z-index: 200;
}

#zoid-paypal-button-b6dd1adcab > .zoid-outlet > iframe.zoid-visible {
  opacity: 1;
}

#zoid-paypal-button-b6dd1adcab > .zoid-outlet > iframe.zoid-invisible {
  opacity: 0;
  pointer-events: none;
}
</style>