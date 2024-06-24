!/**
 * Highcharts JS v11.4.3 (2024-05-22)
 *
 * (c) 2009-2024
 *
 * License: www.highcharts.com/license
 */function(t){"object"==typeof module&&module.exports?(t.default=t,module.exports=t):"function"==typeof define&&define.amd?define("highcharts/modules/geoheatmap",["highcharts"],function(e){return t(e),t.Highcharts=e,t}):t("undefined"!=typeof Highcharts?Highcharts:void 0)}(function(t){"use strict";var e=t?t._modules:{};function o(t,e,o,i){t.hasOwnProperty(e)||(t[e]=i.apply(null,o),"function"==typeof CustomEvent&&window.dispatchEvent(new CustomEvent("HighchartsModuleLoaded",{detail:{path:e,module:t[e]}})))}o(e,"Series/GeoHeatmap/GeoHeatmapPoint.js",[e["Core/Utilities.js"],e["Core/Series/SeriesRegistry.js"]],function(t,e){var o,i=this&&this.__extends||(o=function(t,e){return(o=Object.setPrototypeOf||({__proto__:[]})instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var o in e)Object.prototype.hasOwnProperty.call(e,o)&&(t[o]=e[o])})(t,e)},function(t,e){if("function"!=typeof e&&null!==e)throw TypeError("Class extends value "+String(e)+" is not a constructor or null");function i(){this.constructor=t}o(t,e),t.prototype=null===e?Object.create(e):(i.prototype=e.prototype,new i)}),n=e.seriesTypes.map.prototype.pointClass,r=t.isNumber;return function(t){function e(){return null!==t&&t.apply(this,arguments)||this}return i(e,t),e.prototype.applyOptions=function(e,o){var i=t.prototype.applyOptions.call(this,e,o),n=i.options,a=n.lat,s=n.lon;if(r(s)&&r(a)){var p=this.series.options,l=p.colsize,h=void 0===l?1:l,c=p.rowsize,u=void 0===c?1:c,d=s-h/2,y=a-u/2;i.geometry=i.options.geometry={type:"Polygon",coordinates:[[[d,y],[d+h,y],[d+h,y+u],[d,y+u],[d,y]]]}}return i},e}(n)}),o(e,"Series/InterpolationUtilities.js",[e["Core/Globals.js"],e["Core/Utilities.js"]],function(t,e){var o=t.doc,i=e.defined,n=e.pick;return{colorFromPoint:function(t,e){var o=e.series.colorAxis;if(o){var r=o.toColor(t||0,e).split(")")[0].split("(")[1].split(",").map(function(t){return n(parseFloat(t),parseInt(t,10))});return r[3]=255*n(r[3],1),i(t)&&e.visible||(r[3]=0),r}return[0,0,0,0]},getContext:function(t){var e=t.canvas,i=t.context;return e&&i?(i.clearRect(0,0,e.width,e.height),i):(t.canvas=o.createElement("canvas"),t.context=t.canvas.getContext("2d",{willReadFrequently:!0})||void 0,t.context)}}}),o(e,"Series/GeoHeatmap/GeoHeatmapSeries.js",[e["Core/Animation/AnimationUtilities.js"],e["Series/GeoHeatmap/GeoHeatmapPoint.js"],e["Core/Globals.js"],e["Series/InterpolationUtilities.js"],e["Core/Series/SeriesRegistry.js"],e["Core/Utilities.js"]],function(t,e,o,i,n,r){var a,s=this&&this.__extends||(a=function(t,e){return(a=Object.setPrototypeOf||({__proto__:[]})instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var o in e)Object.prototype.hasOwnProperty.call(e,o)&&(t[o]=e[o])})(t,e)},function(t,e){if("function"!=typeof e&&null!==e)throw TypeError("Class extends value "+String(e)+" is not a constructor or null");function o(){this.constructor=t}a(t,e),t.prototype=null===e?Object.create(e):(o.prototype=e.prototype,new o)}),p=t.animObject,l=t.stop,h=o.noop,c=i.colorFromPoint,u=i.getContext,d=n.seriesTypes.map,y=r.addEvent,f=r.extend,g=r.isNumber,m=r.isObject,v=r.merge,b=r.pick;function w(t){return t-360*Math.floor((t+180)/360)}var x=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.isDirtyCanvas=!0,e}return s(e,t),e.prototype.update=function(){this.options=v(this.options,arguments[0]),this.getInterpolation().enabled&&(this.isDirtyCanvas=!0,this.points.forEach(function(t){t.graphic&&(t.graphic.destroy(),delete t.graphic)})),t.prototype.update.apply(this,arguments)},e.prototype.translate=function(){(!this.getInterpolation().enabled||!this.image||this.isDirty||this.isDirtyData)&&t.prototype.translate.apply(this,arguments)},e.prototype.getInterpolation=function(){return m(this.options.interpolation)?this.options.interpolation:{blur:1,enabled:this.options.interpolation}},e.prototype.drawPoints=function(){var e=this.chart.mapView,o=this.options;if(this.getInterpolation().enabled&&e&&this.bounds){var i=this.context||u(this),n=this.canvas,r=this.colorAxis,a=this.image,s=this.chart,h=this.points,d=[b(o.colsize,1),b(o.rowsize,1)],y=d[0],f=d[1],m=e.projectedUnitsToPixels({x:this.bounds.x1,y:this.bounds.y2}),w=e.projectedUnitsToPixels({x:this.bounds.x2,y:this.bounds.y1});if(n&&i&&r&&m&&w){var x={x:m.x,y:m.y,width:w.x-m.x,height:w.y-m.y};if(this.isDirtyCanvas||this.isDirtyData||"Orthographic"===e.projection.options.name){this.isDirtyCanvas=!0;var C=n.width=~~(360/y)+1,j=n.height=~~(180/f)+1,D=new Uint8ClampedArray(C*j*4);this.directTouch=!1;for(var _=0;_<h.length;_++){var O=h[_],P=new Uint8ClampedArray(c(O.value,O)),I=O.options,U=I.lon,T=I.lat;g(U)&&g(T)&&D.set(P,4*Math.ceil(C*(j-1-(T+90)/f)+(U+180)/y))}var A=this.getInterpolation().blur,S=0===A?1:11*A,L=~~x.width,H=~~x.height,G=new ImageData(D,C,j);n.width=~~(C*S),n.height=~~(j*S),i.putImageData(G,0,0),i.globalCompositeOperation="copy",i.drawImage(n,0,0,G.width,G.height,0,0,n.width,n.height);var E=i.getImageData(0,0,n.width,n.height),R=new ImageData(this.getProjectedImageData(e,L,H,E,n,x.x,x.y),L,H);i.globalCompositeOperation="copy",n.width=L,n.height=H,i.putImageData(R,0,0)}if(a){if(s.renderer.globalAnimation&&s.hasRendered){var z=Number(a.attr("x")),k=Number(a.attr("y")),M=Number(a.attr("width")),N=Number(a.attr("height")),F=function(t,e){a.attr({x:z+(x.x-z)*e.pos,y:k+(x.y-k)*e.pos,width:M+(x.width-M)*e.pos,height:N+(x.height-N)*e.pos})},X=v(p(s.renderer.globalAnimation)),V=X.step;X.step=function(){V&&V.apply(this,arguments),F.apply(this,arguments)},a.attr(v({animator:0},this.isDirtyCanvas?{href:n.toDataURL("image/png",1)}:void 0)).animate({animator:1},X)}else l(a),a.attr(v(x,this.isDirtyCanvas?{href:n.toDataURL("image/png",1)}:void 0))}else this.image=s.renderer.image(n.toDataURL("image/png",1)).attr(x).add(this.group);this.isDirtyCanvas=!1}}else t.prototype.drawPoints.apply(this,arguments)},e.prototype.getProjectedImageData=function(t,e,o,i,n,r,a){for(var s,p=new Uint8ClampedArray(e*o*4),l=b(null===(s=t.projection.options.rotation)||void 0===s?void 0:s[0],0),h=n.width/360,c=-1*n.height/180,u=-1,d=0;d<p.length;d+=4){var y=d/4%e;0===y&&u++;var f=t.pixelsToLonLat({x:r+y,y:a+u});if(f){f.lon>-180-l&&f.lon<180-l&&(f.lon=w(f.lon));var g=[f.lon,f.lat],m=g[0]*h+n.width/2,v=g[1]*c+n.height/2;if(m>=0&&m<=n.width&&v>=0&&v<=n.height){var x=Math.floor(v)*n.width*4+4*Math.round(m);p[d]=i.data[x],p[d+1]=i.data[x+1],p[d+2]=i.data[x+2],p[d+3]=i.data[x+3]}}}return p},e.prototype.searchPoint=function(t,e){var o=this.chart,i=o.mapView;if(i&&this.bounds&&this.image&&o.tooltip&&o.tooltip.options.enabled){if(!o.pointer.hasDragged&&(.01>=+this.image.attr("animator")||+this.image.attr("animator")>=.99)){var n=i.projectedUnitsToPixels({x:this.bounds.x1,y:this.bounds.y2}),r=i.projectedUnitsToPixels({x:this.bounds.x2,y:this.bounds.y1});if(o.pointer.normalize(t),t.lon&&t.lat&&n&&r&&t.chartX-o.plotLeft>n.x&&t.chartX-o.plotLeft<r.x&&t.chartY-o.plotTop>n.y&&t.chartY-o.plotTop<r.y)return this.searchKDTree({clientX:t.chartX,lon:w(t.lon),lat:t.lat},e,t)}else o.tooltip.destroy()}},e.defaultOptions=v(d.defaultOptions,{nullColor:"transparent",tooltip:{pointFormat:"Lat: {point.lat}, Lon: {point.lon}, Value: {point.value}<br/>"},borderWidth:0,colsize:1,rowsize:1,stickyTracking:!0,interpolation:{enabled:!1,blur:1}}),e}(d);return y(x,"afterDataClassLegendClick",function(){this.isDirtyCanvas=!0,this.drawPoints()}),f(x.prototype,{type:"geoheatmap",applyJitter:h,pointClass:e,pointArrayMap:["lon","lat","value"],kdAxisArray:["lon","lat"]}),n.registerSeriesType("geoheatmap",x),x}),o(e,"masters/modules/geoheatmap.src.js",[e["Core/Globals.js"]],function(t){return t})});