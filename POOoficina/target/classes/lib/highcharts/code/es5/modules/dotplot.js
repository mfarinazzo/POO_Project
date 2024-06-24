!/**
 * Highcharts JS v11.4.3 (2024-05-22)
 *
 * Dot plot series type for Highcharts
 *
 * (c) 2010-2024 Torstein Honsi
 *
 * License: www.highcharts.com/license
 */function(t){"object"==typeof module&&module.exports?(t.default=t,module.exports=t):"function"==typeof define&&define.amd?define("highcharts/modules/dotplot",["highcharts"],function(e){return t(e),t.Highcharts=e,t}):t("undefined"!=typeof Highcharts?Highcharts:void 0)}(function(t){"use strict";var e=t?t._modules:{};function r(t,e,r,o){t.hasOwnProperty(e)||(t[e]=o.apply(null,r),"function"==typeof CustomEvent&&window.dispatchEvent(new CustomEvent("HighchartsModuleLoaded",{detail:{path:e,module:t[e]}})))}r(e,"Series/DotPlot/DotPlotSeriesDefaults.js",[],function(){return{itemPadding:.1,marker:{symbol:"circle",states:{hover:{},select:{}}},slotsPerBar:void 0}}),r(e,"Series/DotPlot/DotPlotSeries.js",[e["Series/DotPlot/DotPlotSeriesDefaults.js"],e["Core/Series/SeriesRegistry.js"],e["Core/Utilities.js"]],function(t,e,r){var o,i=this&&this.__extends||(o=function(t,e){return(o=Object.setPrototypeOf||({__proto__:[]})instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var r in e)Object.prototype.hasOwnProperty.call(e,r)&&(t[r]=e[r])})(t,e)},function(t,e){if("function"!=typeof e&&null!==e)throw TypeError("Class extends value "+String(e)+" is not a constructor or null");function r(){this.constructor=t}o(t,e),t.prototype=null===e?Object.create(e):(r.prototype=e.prototype,new r)}),s=e.seriesTypes.column,n=r.extend,a=r.isNumber,l=r.merge,d=r.pick,u=function(e){function r(){return null!==e&&e.apply(this,arguments)||this}return i(r,e),r.prototype.drawPoints=function(){var t,e,r,o=this.options,i=this.chart.renderer,s=o.marker,l=this.points.reduce(function(t,e){return t+Math.abs(e.y||0)},0),u=this.points.reduce(function(t,e){var r;return t+((null===(r=e.shapeArgs)||void 0===r?void 0:r.height)||0)},0),c=o.itemPadding||0,p=(null===(e=null===(t=this.points[0])||void 0===t?void 0:t.shapeArgs)||void 0===e?void 0:e.width)||0,h=o.slotsPerBar,f=p;if(!a(h))for(h=1;h<l&&!(l/h<u/f*1.2);)f=p/++h;for(var v=u*h/l,y=0,g=this.points;y<g.length;y++){var m=g[y],b=m.marker||{},P=b.symbol||s.symbol,w=d(b.radius,s.radius),A="rect"!==P?v:f,j=m.shapeArgs||{},_=(j.x||0)+((j.width||0)-h*A)/2,S=Math.abs(null!==(r=m.y)&&void 0!==r?r:0),D=j.y||0,O=j.height||0,k=void 0,x=_,C=m.negative?D:D+O-v,E=0;m.graphics=k=m.graphics||[];var H=m.pointAttr?m.pointAttr[m.selected?"selected":""]||this.pointAttr[""]:this.pointAttribs(m,m.selected&&"select");if(delete H.r,this.chart.styledMode&&(delete H.stroke,delete H["stroke-width"]),"number"==typeof m.y){m.graphic||(m.graphic=i.g("point").add(this.group));for(var M=0;M<S;M++){var T={x:x+A*c,y:C+v*c,width:A*(1-2*c),height:v*(1-2*c),r:w},B=k[M];B?B.animate(T):B=i.symbol(P).attr(n(T,H)).add(m.graphic),B.isActive=!0,k[M]=B,x+=A,++E>=h&&(E=0,x=_,C=m.negative?C+v:C-v)}}for(var G=-1,L=0,N=k;L<N.length;L++){var B=N[L];++G,B&&(B.isActive?B.isActive=!1:(B.destroy(),k.splice(G,1)))}}},r.defaultOptions=l(s.defaultOptions,t),r}(s);return n(u.prototype,{markerAttribs:void 0}),e.registerSeriesType("dotplot",u),u}),r(e,"masters/modules/dotplot.src.js",[e["Core/Globals.js"]],function(t){return t})});