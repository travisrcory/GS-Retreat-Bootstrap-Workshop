YUI.add("aui-scheduler-view-day",function(e,t){var n=e.Lang,r=n.isBoolean,i=n.isFunction,s=n.isNumber,o=n.isObject,u=n.isString,a=e.DataType.DateMath,f=e.WidgetStdMod,l="a",c=",",h=".",p="",d="%",v=" ",m="data-colnumber",g="scheduler-view",y="scheduler-view-day",b=e.cached(function(){var t=e.config.doc,n=t.createElement("div"),r=t.getElementsByTagName("body")[0],i=.1;return r&&(n.style.cssText="position:absolute;visibility:hidden;overflow:scroll;width:20px;",n.appendChild(t.createElement("p")).style.height="1px",r.insertBefore(n,r.firstChild),i=n.offsetWidth-n.clientWidth,r.removeChild(n)),i},null,.1),w=function(e,t){return function(n){var r=n.all(e);return r.size()>=t?r:null}},E=function(e,t){return Math.round(e/t)*t},S=function(e){return parseFloat(e)||0},x="activeColumn",T="activeView",N="allDay",C="boundingBox",k="col",L="colDaysNode",A="colHeaderDaysNode",O="colblank",M="coldata",_="colday",D="colgrid",P="colspan",H="coltime",B="columnData",j="columnDayHeader",F="columnShims",I="columnTime",q="container",R="creationStartDate",U="data",z="date",W="day",X="days",V="delegateConfig",$="disabled",J="division",K="draggingEvent",Q="duration",G="endDate",Y="eventPlaceholder",Z="eventRecorder",et="eventWidth",tt="filterFn",nt="first",rt="grid",it="gridContainer",st="grip",ot="hd",ut="header",at="headerDateFormatter",ft="headerTableNode",lt="headerView",ct="headerViewConfig",ht="headerViewLabelNode",pt="height",dt="horizontal",vt="host",mt="hourHeight",gt="icon",yt="isoTime",bt="label",wt="left",Et="locale",St="paddingRight",xt="region",Tt="resizer",Nt="resizerNode",Ct="resizing",kt="scheduler",Lt="scheduler-event",At="shim",Ot="startDate",Mt="startXY",_t="strings",Dt="table",Pt="tableNode",Ht="time",Bt="timesNode",jt="today",Ft="todayDate",It="top",qt="view",Rt="viewDate",Ut="visible",zt="width",Wt="marker",Xt="markercell",Vt="markercellsNode",$t="markers",Jt="markersNode",Kt="node",Qt="offsetHeight",Gt="parentNode",Yt="proxy",Zt="px",en=e.getClassName,tn=en(g,Dt,U),nn=en(Lt),rn=en(Lt,$),sn=en(Lt,Yt),on=en(kt,jt),un=en(kt,jt,ot),an=en(g,M),fn=en(g,D),ln=en(g,rt),cn=en(g,rt,q),hn=en(g,W,ut,k),pn=en(g,W,ut,W),dn=en(g,W,ut,W,nt),vn=en(g,W,ut,Dt),mn=en(g,W,ut,qt,bt),gn=en(g,gt,st,dt),yn=en(g,Wt,J),bn=en(g,Xt),wn=en(g,$t),En=en(g,W,Tt),Sn=en(g,W,Tt,gt),xn=en(g,W,Dt),Tn=en(g,W,Dt,k),Nn=en(g,W,Dt,k,At),Cn=en(g,W,Dt,O),kn=en(g,W,Dt,_),Ln=en(g,W,Dt,H),An=en(g,W,Dt,Ht),On='<div class="'+En+'">'+'<div class="'+[gn,Sn].join(v)+'"></div>'+"</div>",Mn='<div class="'+bn+'">'+'<div class="'+yn+'"></div>'+"</div>",_n='<span class="'+mn+'">{label}</span>',Dn='<table cellspacing="0" cellpadding="0" class="'+xn+'">'+"<tbody>"+'<tr class="'+fn+'" height="1">'+'<td height="0" class="'+[Tn,Cn].join(v)+'"></td>'+'<td class="'+cn+'" colspan="1">'+'<div class="'+ln+'">'+'<div class="'+wn+'"></div>'+"</div>"+"</td>"+"</tr>"+'<tr class="'+an+'">'+'<td class="'+[Tn,Ln].join(v)+'"></td>'+"</tr>"+"</tbody>"+"</table>",Pn='<td class="'+[Tn,kn].join(v)+'" data-colnumber="{colNumber}">'+'<div class="'+Nn+'">&nbsp;</div>'+"</td>",Hn='<div class="'+An+'">{hour}</div>',Bn='<table cellspacing="0" cellpadding="0" class="'+vn+'">'+"<tbody>"+'<tr class="'+hn+'"></tr>'+"</tbody>"+"</table>",jn='<th class="'+pn+'" data-colnumber="{colNumber}"><a href="#">&nbsp;</a></th>',Fn='<td class="'+[pn,dn].join(v)+'"></td>',In=e.Component.create({NAME:y,ATTRS:{bodyContent:{value:p},days:{value:1,validator:s},delegateConfig:{value:{},setter:function(t){var n=this;return e.merge({dragConfig:{useShim:!1},bubbleTargets:n,container:n.get(C),nodes:h+nn,invalid:"input, select, button, a, textarea, "+h+rn},t||{})},validator:o},eventWidth:{value:95,validator:s},filterFn:{value:function(e){return e.getHoursDuration()<=24&&!e.get(N)}},headerDateFormatter:{value:function(t){var n=this,r=n.get(kt);return e.DataType.Date.format(t,{format:"<span>%d</span> %a",locale:r.get(Et)})},validator:u},headerView:{value:!0,validator:r},headerViewConfig:{setter:function(t){var n=this;return e.merge({displayDaysInterval:1,displayRows:6,filterFn:function(e){return e.getHoursDuration()>24||e.get(N)},height:"auto",visible:!0},t||{})},value:{}},hourHeight:{value:52,validator:s},name:{value:W},navigationDateFormatter:{value:function(t){var n=this,r=n.get(kt);return e.DataType.Date.format(t,{format:"%A, %B %d, %Y",locale:r.get(Et)})},validator:i},strings:{value:{allDay:"All day"}},headerTableNode:{valueFn:function(){return e.Node.create(Bn)}},headerViewLabelNode:{valueFn:function(){var t=this,r=t.get(_t);return e.Node.create(n.sub(_n,{label:r[N]}))}},resizerNode:{valueFn:function(){return e.Node.create(On)}},tableNode:{valueFn:function(){return e.Node.create(Dn)}},colDaysNode:{valueFn:"_valueColDaysNode"},colHeaderDaysNode:{valueFn:"_valueColHeaderDaysNode"},markercellsNode:{valueFn:"_valueMarkercellsNode"},timesNode:{valueFn:"_valueTimesNode"}},HTML_PARSER:{colDaysNode:w(h+kn,1),colHeaderDaysNode:w(h+pn,2),headerTableNode:h+vn,headerViewLabelNode:h+mn,markercellsNode:w(h+bn,24),resizerNode:h+En,tableNode:h+xn,timesNode:w(h+An,24)},EXTENDS:e.SchedulerView,prototype:{initializer:function(){var t=this;t[L]=t.get(L),t[A]=t.get(A),t[ft]=t.get(ft),t[Vt]=t.get(Vt),t[Nt]=t.get(Nt),t[Pt]=t.get(Pt),t[Bt]=t.get(Bt),t[x]=null,t[B]=t[Pt].one(h+an),t[j]=t.headerTableNode.one(h+hn),t[F]=t[L].all(h+Nn),t[I]=t[Pt].one(h+Ln),t[it]=t[Pt].one(h+cn),t[Jt]=t[Pt].one(h+wn),t.get(lt)&&(t[lt]=new e.SchedulerTableView(t.get(ct)))},renderUI:function(){var e=this;e[I].setContent(e[Bt]),e[Jt].setContent(e[Vt]),e[L].appendTo(e[B]),e[A].appendTo(e[j]),e[lt]&&(e[lt].set(kt,e.get(kt)),e[lt].render())},bindUI:function(){var t=this;t[ft].delegate("click",e.bind(t._onClickDaysHeader,t),h+pn),t[B].delegate("mousedown",e.bind(t._onMouseDownTableCol,t),h+Tn),t[B].delegate("mouseenter",e.bind(t._onMouseEnterEvent,t),h+nn),t[B].delegate("mouseleave",e.bind(t._onMouseLeaveEvent,t),h+nn),t[B].delegate("mousemove",e.bind(t._onMouseMoveTableCol,t),h+kn),t[B].delegate("mouseup",e.bind(t._onMouseUpTableCol,t),h+Tn),t.on("drag:end"
,t._onEventDragEnd),t.on("drag:start",t._onEventDragStart),t.on("drag:tickAlignY",t._dragTickAlignY),t.on("schedulerChange",t._onSchedulerChange),t.after("drag:align",t._afterDragAlign)},syncUI:function(){var e=this;In.superclass.syncUI.apply(this,arguments),e[it].attr(P,e.get(X)),e._setupDragDrop()},syncStdContent:function(){var t=this;t.setStdModContent(f.BODY,t[Pt].getDOM());var n=e.NodeList.create(t[ft]);t[lt]&&(n.push(t[lt].get(C)),n.push(t.get(ht))),t.setStdModContent(f.HEADER,n)},calculateEventHeight:function(e){var t=this,n=t.get(mt);return Math.max(e*(n/60),n/2)},calculateTop:function(e){var t=this;return(e.getHours()*60+e.getMinutes()+e.getSeconds()/60)*(t.get(mt)/60)},getNextDate:function(){var e=this,t=e.get(kt).get(Rt);return a.toLastHour(a.add(t,a.DAY,1))},getPrevDate:function(){var e=this,t=e.get(kt).get(Rt);return a.toMidnight(a.subtract(t,a.DAY,1))},getColumnByDate:function(e){var t=this;return t[L].item(t.getDateDaysOffset(e))},getColumnShimByDate:function(e){var t=this;return t[F].item(t.getDateDaysOffset(e))},getDateByColumn:function(e){var t=this,n=a.safeClearTime(t.get(kt).get(Rt));return a.add(n,a.DAY,e)},getDateDaysOffset:function(e){var t=this,n=a.safeClearTime(t.get(kt).get(Rt));return a.getDayOffset(a.safeClearTime(e),n)},getYCoordTime:function(e){var t=this,n=t.get(mt),r=S((e/n).toFixed(2)),i=Math.floor(r*100%100*.6),s=Math.floor(r);return[s,i,0]},plotEvent:function(e){var t=this,n=e.get(Kt);n.size()<2&&e.addPaddingNode();var r=e.get(Kt).item(0),i=e.get(Kt).item(1),s=t.getColumnShimByDate(e.get(G)),o=t.getColumnShimByDate(e.get(Ot));o?(o.append(r),e.get(Ut)&&r.show()):r.hide(),s?s.compareTo(o)||e.isDayBoundaryEvent()?i.hide():(s.append(i),e.get(Ut)&&i.show()):i.hide(),e.syncUI(),t.syncEventTopUI(e),t.syncEventHeightUI(e)},plotEvents:function(){var t=this,n=t.get(kt),r=t.get(tt);t[F].each(function(i,s){var o=n.getEventsByDay(t.getDateByColumn(s),!0),u=[];i.empty(),e.Array.each(o,function(e){r.apply(t,[e])&&(t.plotEvent(e),u.push(e))}),t.syncEventsIntersectionUI(u)}),t.syncHeaderViewUI()},syncColumnsUI:function(){var e=this,t=e.get(kt).get(Ft);e[L].each(function(n,r){var i=e.getDateByColumn(r);n.toggleClass(on,!a.isDayOverlap(i,t))})},syncDaysHeaderUI:function(){var e=this,t=e.get(kt).get(Rt),n=e.get(at),r=e.get(Et),i=e.get(kt).get(Ft);e[A].all(l).each(function(r,s){var o=a.add(t,a.DAY,s);r.toggleClass(un,!a.isDayOverlap(o,i)),r.html(n.call(e,o))})},syncEventsIntersectionUI:function(t){var n=this,r=n.get(et);n.get(kt).flushEvents(),e.Array.each(t,function(i){var s=n.findEventIntersections(i,t),o=s.length,u=r/o;e.Array.each(s,function(e,t){var n=e.get(Kt).item(0),i=u*t,s=u*1.7;t===o-1&&(s=r-i),n.setStyle(zt,s+d),n.setStyle(wt,i+d);var a=n.get(Gt);a&&a.insert(n,t),e._filtered=!0})})},syncEventHeightUI:function(e){var t=this,n=e.get(G),r=e.get(Ot),i=a.clone(r);i.setHours(24,0,0);var s=a.getMinutesOffset(t.limitDate(n,i),r);e.get(Kt).item(0).set(Qt,t.calculateEventHeight(s));var o=e.get(Kt).item(1);if(o.inDoc()){var u=a.getMinutesOffset(n,a.toMidnight(e.getClearEndDate()));o.set(Qt,t.calculateEventHeight(u))}},syncEventTopUI:function(e){var t=this;e.get(Kt).item(0).setStyle(It,t.calculateTop(e.get(Ot))+Zt),e.get(Kt).item(1).setStyle(It,0)},syncHeaderViewUI:function(){var e=this;if(e.get(lt)){var t=e[lt];t.plotEvents(),e.headerNode.setStyle(St,b());var n=t.get(C),r=n.one(h+tn),i=Math.max(r.get(Qt),40);t.set(pt,i),e._fillHeight()}},calculateYDelta:function(e,t){var n=this;return(t[1]-e[1])/(n.get(mt)/2)*30},findEventIntersections:function(t,n){var r=this,i=[];return e.Array.each(n,function(e){!t._filtered&&e.get(Ut)&&t.intersectHours(e)&&i.push(e)}),i},getXYDelta:function(t){var n=this,r=t.currentTarget.getXY(),i=[t.pageX,t.pageY];return e.Array.map(r,function(e,t){return i[t]-e})},getTickY:function(){var e=this;return E(Math.ceil(e.get(mt)/2),10)},roundToNearestHour:function(e,t){var n=this;e.setHours(t[0],E(t[1],n.getTickY()),t[2])},_afterDragAlign:function(e){var t=this,n=e.target;t[Mt]||(t[Mt]=n.actXY),n.actXY[0]=null},_dragTickAlignX:function(e){var t=this,n=t[K];if(n&&!t[Ct]){var r=t[Y],i=S(e.attr(m))-t.startColNumber;t.draggingEventStartDate=a.add(n.get(Ot),a.DAY,i);var s=a.clone(t.draggingEventStartDate);a.copyHours(s,r.get(Ot)),r.move(s,{silent:!0}),t.plotEvent(r)}},_dragTickAlignY:function(e){var t=this,n=t.get(kt),r=n.get(Z),i=t[K];if(i){var s=e.target.get(vt),o=t[Y],u=t.calculateYDelta(t[Mt],s.actXY);if(t[Ct]){var f=a.add(t.draggingEventEndDate,a.MINUTES,u);if(a.getMinutesOffset(f,t.draggingEventStartDate)<30)return;o.set(G,f,{silent:!0})}else o.move(a.add(t.draggingEventStartDate,a.MINUTES,u),{silent:!0});t.plotEvent(o)}},_setupDragDrop:function(){var t=this,n=t[Y];if(!n){var r=t.get(kt);n=new r.eventModel({scheduler:r}),n.removeTarget(r),n.get(Kt).addClass(sn),n.set(Ut,!1,{silent:!0}),t[Y]=n}t.delegate||(t.delegate=new e.DD.Delegate(t.get(V)));var i=t.delegate.dd;i.unplug(e.Plugin.DDConstrained),i.unplug(e.Plugin.DDNodeScroll);var s=t.bodyNode.get(xt);s.bottom=Infinity,s.top=-Infinity,i.plug(e.Plugin.DDConstrained,{bubbleTargets:t,constrain:s,stickY:!0,tickY:t.get(mt)/2}),i.plug(e.Plugin.DDNodeScroll,{node:t.bodyNode,scrollDelay:150})},_uiSetDate:function(e){var t=this;t.syncColumnsUI(),t.syncDaysHeaderUI()},_onClickDaysHeader:function(e){var t=this,n=t.get(kt);if(e.target.test("a, a span")){var r=n.getViewByName(W);if(r){var i=S(e.currentTarget.attr(m));n.set(z,t.getDateByColumn(i)),n.set(T,r)}}e.preventDefault()},_onEventDragEnd:function(e){var t=this,n=t[K];if(n){var r=t[Y];r.set(Ut,!1,{silent:!0}),n.set(Ut,!0,{silent:!0}),n.copyDates(r),t.get(kt).syncEventsUI()}t[Mt]=null,t[K]=null},_onEventDragStart:function(e){var t=this,n=t[K]=t.delegate.dd.get(Kt).getData(Lt);if(n){var r=t[Y];r.copyPropagateAttrValues(n,null,{silent:!0}),t.plotEvent(r),n.set(Ut,!1,{silent:!0}),t.draggingEventStartDate=a.clone(n.get(Ot)),t.draggingEventEndDate=a.clone(n.get(G));var i=t.getColumnByDate(n.get(Ot));t.startColNumber=i?S(i.attr(m)):0}},_onMouseDownTableCol:function(e){var t=
this,n=e.target,r=t.get(kt),i=r.get(Z);if(i&&!r.get($)){i.hidePopover();if(n.test(h+Nn)){t[Mt]=[e.pageX,e.pageY];var s=S(e.currentTarget.attr(m)),o=t.getDateByColumn(s),u=t.getXYDelta(e);t.roundToNearestHour(o,t.getYCoordTime(u[1]));var f=a.add(o,a.MINUTES,i.get(Q));i.move(o,{silent:!0}),i.setAttrs({allDay:!1,endDate:f},{silent:!0}),t[R]=o,e.halt()}else n.test([h+En,h+Sn].join(c))&&(t[Ct]=!0)}t.get(C).unselectable()},_onMouseEnterEvent:function(e){var t=this,n=e.currentTarget,r=n.getData(Lt);r&&!r.get($)&&t[Nt].appendTo(n)},_onMouseLeaveEvent:function(e){var t=this;t[Ct]||t._removeResizer()},_onMouseMoveTableCol:function(e){var t=this,n=e.currentTarget,r=t.get(kt).get(Z);t[x]!==n&&(t[x]=n,t._dragTickAlignX(t[x]));var i=t[R];if(i){var s=E(t.calculateYDelta(t[Mt],[e.pageX,e.pageY]),t.getTickY()),o=s>=t._delta;if(t._delta!==s){if(s>0){var u=o?Math.max(s,r.get(Q)):s;r.set(G,a.add(i,a.MINUTES,u),{silent:!0})}else r.set(Ot,a.add(i,a.MINUTES,s),{silent:!0});t.plotEvent(r),t._delta=s}}},_onMouseUpTableCol:function(e){var t=this,n=t.get(kt),r=n.get(Z);r&&!n.get($)&&t[R]&&(t.plotEvent(r),r.showPopover()),t[R]=null,t[Ct]=!1,t[Mt]=null,t._removeResizer(),t.get(C).selectable()},_onSchedulerChange:function(e){var t=this;t[lt]&&t[lt].set(kt,e.newVal)},_removeResizer:function(){var e=this;e[Nt].remove()},_valueColDaysNode:function(){var t=this,n=t.get(X),r=[],i=0;while(n--)r.push(e.Lang.sub(Pn,{colNumber:i++}));return e.NodeList.create(r.join(p))},_valueColHeaderDaysNode:function(){var t=this,n=t.get(X),r=[],i=0;r.push(Fn);while(n--)r.push(e.Lang.sub(jn,{colNumber:i++}));return e.NodeList.create(r.join(p))},_valueMarkercellsNode:function(){var t=this,n=[],r;for(r=0;r<=23;r++)n.push(Mn);return e.NodeList.create(n.join(p))},_valueTimesNode:function(){var t=this,r=t.get(yt),i=[],s;for(s=0;s<=23;s++)i.push(n.sub(Hn,{hour:r?a.toIsoTimeString(s):a.toUsTimeString(s,!1,!0)}));return e.NodeList.create(i.join(p))}}});e.SchedulerDayView=In},"2.0.0",{requires:["dd-drag","dd-delegate","dd-drop","dd-constrain","aui-scheduler-view-table"],skinnable:!0});