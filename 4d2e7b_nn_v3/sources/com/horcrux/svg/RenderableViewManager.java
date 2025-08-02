package com.horcrux.svg;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.p;
import com.horcrux.svg.RenderableView;
import com.horcrux.svg.VirtualViewManager;
import com.horcrux.svg.events.SvgLoadEvent;
import e6.f;
import java.util.HashMap;
import java.util.Map;
import p7.a1;
import p7.a2;
import p7.b1;
import p7.b2;
import p7.c0;
import p7.c1;
import p7.c2;
import p7.d0;
import p7.d1;
import p7.d2;
import p7.e0;
import p7.e1;
import p7.e2;
import p7.f0;
import p7.f1;
import p7.f2;
import p7.g0;
import p7.g1;
import p7.g2;
import p7.h0;
import p7.h1;
import p7.h2;
import p7.i0;
import p7.i1;
import p7.j0;
import p7.j1;
import p7.k0;
import p7.k1;
import p7.l0;
import p7.l1;
import p7.m0;
import p7.m1;
import p7.n0;
import p7.n1;
import p7.o0;
import p7.o1;
import p7.p0;
import p7.p1;
import p7.q0;
import p7.q1;
import p7.r0;
import p7.r1;
import p7.s0;
import p7.s1;
import p7.t0;
import p7.t1;
import p7.u0;
import p7.u1;
import p7.v0;
import p7.v1;
import p7.w0;
import p7.x0;
import p7.y0;
import p7.y1;
import p7.z0;
import p7.z1;

class RenderableViewManager<T extends RenderableView> extends VirtualViewManager<T> {

    static class CircleViewManager extends RenderableViewManager<CircleView> implements d0 {
        public static final String REACT_CLASS = "RNSVGCircle";

        CircleViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGCircle);
            this.mDelegate = new c0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "cx")
        public void setCx(CircleView circleView, Dynamic dynamic) {
            circleView.p(dynamic);
        }

        @h7.a(name = "cy")
        public void setCy(CircleView circleView, Dynamic dynamic) {
            circleView.q(dynamic);
        }

        @h7.a(name = "r")
        public void setR(CircleView circleView, Dynamic dynamic) {
            circleView.r(dynamic);
        }
    }

    static class ClipPathViewManager extends GroupViewManagerAbstract<ClipPathView> implements f0 {
        public static final String REACT_CLASS = "RNSVGClipPath";

        ClipPathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGClipPath);
            this.mDelegate = new e0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((GroupView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }
    }

    static class DefsViewManager extends VirtualViewManager<DefsView> implements h0 {
        public static final String REACT_CLASS = "RNSVGDefs";

        DefsViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGDefs);
            this.mDelegate = new g0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }
    }

    static class EllipseViewManager extends RenderableViewManager<EllipseView> implements j0 {
        public static final String REACT_CLASS = "RNSVGEllipse";

        EllipseViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGEllipse);
            this.mDelegate = new i0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "cx")
        public void setCx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.p(dynamic);
        }

        @h7.a(name = "cy")
        public void setCy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.q(dynamic);
        }

        @h7.a(name = "rx")
        public void setRx(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.r(dynamic);
        }

        @h7.a(name = "ry")
        public void setRy(EllipseView ellipseView, Dynamic dynamic) {
            ellipseView.s(dynamic);
        }
    }

    static class FeBlendManager extends FilterPrimitiveManager<FeBlendView> implements l0 {
        public static final String REACT_CLASS = "RNSVGFeBlend";

        FeBlendManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeBlend);
            this.mDelegate = new k0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "height")
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FilterPrimitiveView) view, str);
        }

        @h7.a(name = "width")
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "in1")
        public void setIn1(FeBlendView feBlendView, String str) {
            feBlendView.z(str);
        }

        @h7.a(name = "in2")
        public void setIn2(FeBlendView feBlendView, String str) {
            feBlendView.A(str);
        }

        @h7.a(name = "mode")
        public void setMode(FeBlendView feBlendView, String str) {
            feBlendView.B(str);
        }
    }

    static class FeColorMatrixManager extends FilterPrimitiveManager<FeColorMatrixView> implements n0 {
        public static final String REACT_CLASS = "RNSVGFeColorMatrix";

        FeColorMatrixManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeColorMatrix);
            this.mDelegate = new m0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "height")
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FilterPrimitiveView) view, str);
        }

        @h7.a(name = "width")
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "in1")
        public void setIn1(FeColorMatrixView feColorMatrixView, String str) {
            feColorMatrixView.x(str);
        }

        @h7.a(name = "type")
        public void setType(FeColorMatrixView feColorMatrixView, String str) {
            feColorMatrixView.y(str);
        }

        @h7.a(name = "values")
        public void setValues(FeColorMatrixView feColorMatrixView, ReadableArray readableArray) {
            feColorMatrixView.z(readableArray);
        }
    }

    static class FeCompositeManager extends FilterPrimitiveManager<FeCompositeView> implements p0 {
        public static final String REACT_CLASS = "RNSVGFeComposite";

        FeCompositeManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeComposite);
            this.mDelegate = new o0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "height")
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FilterPrimitiveView) view, str);
        }

        @h7.a(name = "width")
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "in1")
        public void setIn1(FeCompositeView feCompositeView, String str) {
            feCompositeView.x(str);
        }

        @h7.a(name = "in2")
        public void setIn2(FeCompositeView feCompositeView, String str) {
            feCompositeView.y(str);
        }

        @h7.a(name = "k1")
        public void setK1(FeCompositeView feCompositeView, float f10) {
            feCompositeView.z(Float.valueOf(f10));
        }

        @h7.a(name = "k2")
        public void setK2(FeCompositeView feCompositeView, float f10) {
            feCompositeView.A(Float.valueOf(f10));
        }

        @h7.a(name = "k3")
        public void setK3(FeCompositeView feCompositeView, float f10) {
            feCompositeView.B(Float.valueOf(f10));
        }

        @h7.a(name = "k4")
        public void setK4(FeCompositeView feCompositeView, float f10) {
            feCompositeView.C(Float.valueOf(f10));
        }

        @h7.a(name = "operator1")
        public void setOperator1(FeCompositeView feCompositeView, String str) {
            feCompositeView.D(str);
        }
    }

    static class FeFloodManager extends FilterPrimitiveManager<FeFloodView> implements r0 {
        public static final String REACT_CLASS = "RNSVGFeFlood";

        FeFloodManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeFlood);
            this.mDelegate = new q0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "height")
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FilterPrimitiveView) view, str);
        }

        @h7.a(name = "width")
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "floodColor")
        public void setFloodColor(FeFloodView feFloodView, Dynamic dynamic) {
            feFloodView.x(dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "floodOpacity")
        public void setFloodOpacity(FeFloodView feFloodView, float f10) {
            feFloodView.z(f10);
        }

        public void setFloodColor(FeFloodView feFloodView, ReadableMap readableMap) {
            feFloodView.y(readableMap);
        }
    }

    static class FeGaussianBlurManager extends FilterPrimitiveManager<FeGaussianBlurView> implements t0 {
        public static final String REACT_CLASS = "RNSVGFeGaussianBlur";

        FeGaussianBlurManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeGaussianBlur);
            this.mDelegate = new s0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "height")
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FilterPrimitiveView) view, str);
        }

        @h7.a(name = "width")
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "values")
        public void setEdgeMode(FeGaussianBlurView feGaussianBlurView, String str) {
            feGaussianBlurView.y(str);
        }

        @h7.a(name = "in1")
        public void setIn1(FeGaussianBlurView feGaussianBlurView, String str) {
            feGaussianBlurView.z(str);
        }

        @h7.a(name = "stdDeviationX")
        public void setStdDeviationX(FeGaussianBlurView feGaussianBlurView, float f10) {
            feGaussianBlurView.A(f10);
        }

        @h7.a(name = "stdDeviationY")
        public void setStdDeviationY(FeGaussianBlurView feGaussianBlurView, float f10) {
            feGaussianBlurView.B(f10);
        }
    }

    static class FeMergeManager extends FilterPrimitiveManager<FeMergeView> implements v0 {
        public static final String REACT_CLASS = "RNSVGFeMerge";

        FeMergeManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeMerge);
            this.mDelegate = new u0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "height")
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FilterPrimitiveView) view, str);
        }

        @h7.a(name = "width")
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "nodes")
        public void setNodes(FeMergeView feMergeView, ReadableArray readableArray) {
            feMergeView.x(readableArray);
        }
    }

    static class FeOffsetManager extends FilterPrimitiveManager<FeOffsetView> implements x0 {
        public static final String REACT_CLASS = "RNSVGFeOffset";

        FeOffsetManager() {
            super(VirtualViewManager.SVGClass.RNSVGFeOffset);
            this.mDelegate = new w0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "height")
        public /* bridge */ /* synthetic */ void setHeight(View view, Dynamic dynamic) {
            super.setHeight((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "result")
        public /* bridge */ /* synthetic */ void setResult(View view, String str) {
            super.setResult((FilterPrimitiveView) view, str);
        }

        @h7.a(name = "width")
        public /* bridge */ /* synthetic */ void setWidth(View view, Dynamic dynamic) {
            super.setWidth((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((FilterPrimitiveView) view, dynamic);
        }

        @h7.a(name = "dx")
        public void setDx(FeOffsetView feOffsetView, Dynamic dynamic) {
            feOffsetView.x(dynamic);
        }

        @h7.a(name = "dy")
        public void setDy(FeOffsetView feOffsetView, Dynamic dynamic) {
            feOffsetView.y(dynamic);
        }

        @h7.a(name = "in1")
        public void setIn1(FeOffsetView feOffsetView, String str) {
            feOffsetView.z(str);
        }
    }

    static class FilterManager extends VirtualViewManager<FilterView> implements z0 {
        public static final String REACT_CLASS = "RNSVGFilter";

        FilterManager() {
            super(VirtualViewManager.SVGClass.RNSVGFilter);
            this.mDelegate = new y0(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(name = "filterUnits")
        public void setFilterUnits(FilterView filterView, String str) {
            filterView.q(str);
        }

        @h7.a(name = "height")
        public void setHeight(FilterView filterView, Dynamic dynamic) {
            filterView.r(dynamic);
        }

        @h7.a(name = "primitiveUnits")
        public void setPrimitiveUnits(FilterView filterView, String str) {
            filterView.s(str);
        }

        @h7.a(name = "width")
        public void setWidth(FilterView filterView, Dynamic dynamic) {
            filterView.t(dynamic);
        }

        @h7.a(name = "x")
        public void setX(FilterView filterView, Dynamic dynamic) {
            filterView.u(dynamic);
        }

        @h7.a(name = "y")
        public void setY(FilterView filterView, Dynamic dynamic) {
            filterView.v(dynamic);
        }
    }

    static class FilterPrimitiveManager<T extends FilterPrimitiveView> extends VirtualViewManager<T> {
        protected FilterPrimitiveManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "height")
        public void setHeight(T t10, Dynamic dynamic) {
            t10.s(dynamic);
        }

        @h7.a(name = "result")
        public void setResult(T t10, String str) {
            t10.t(str);
        }

        @h7.a(name = "width")
        public void setWidth(T t10, Dynamic dynamic) {
            t10.u(dynamic);
        }

        @h7.a(name = "x")
        public void setX(T t10, Dynamic dynamic) {
            t10.v(dynamic);
        }

        @h7.a(name = "y")
        public void setY(T t10, Dynamic dynamic) {
            t10.w(dynamic);
        }
    }

    static class ForeignObjectManager extends GroupViewManagerAbstract<ForeignObjectView> implements b1 {
        public static final String REACT_CLASS = "RNSVGForeignObject";

        ForeignObjectManager() {
            super(VirtualViewManager.SVGClass.RNSVGForeignObject);
            this.mDelegate = new a1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((GroupView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "height")
        public void setHeight(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.A(dynamic);
        }

        @h7.a(name = "width")
        public void setWidth(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.B(dynamic);
        }

        @h7.a(name = "x")
        public void setX(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.C(dynamic);
        }

        @h7.a(name = "y")
        public void setY(ForeignObjectView foreignObjectView, Dynamic dynamic) {
            foreignObjectView.D(dynamic);
        }
    }

    static class GroupViewManager extends GroupViewManagerAbstract<GroupView> implements d1 {
        public static final String REACT_CLASS = "RNSVGGroup";

        GroupViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGGroup);
            this.mDelegate = new c1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((GroupView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }
    }

    static class GroupViewManagerAbstract<U extends GroupView> extends RenderableViewManager<U> {
        GroupViewManagerAbstract(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "font")
        public void setFont(U u10, Dynamic dynamic) {
            u10.x(dynamic);
        }

        @h7.a(name = "fontSize")
        public void setFontSize(U u10, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i10 = a.f9682a[dynamic.getType().ordinal()];
            if (i10 == 1) {
                javaOnlyMap.putDouble("fontSize", dynamic.asDouble());
            } else if (i10 == 2) {
                javaOnlyMap.putString("fontSize", dynamic.asString());
            } else {
                return;
            }
            u10.y(javaOnlyMap);
        }

        @h7.a(name = "fontWeight")
        public void setFontWeight(U u10, Dynamic dynamic) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            int i10 = a.f9682a[dynamic.getType().ordinal()];
            if (i10 == 1) {
                javaOnlyMap.putDouble("fontWeight", dynamic.asDouble());
            } else if (i10 == 2) {
                javaOnlyMap.putString("fontWeight", dynamic.asString());
            } else {
                return;
            }
            u10.y(javaOnlyMap);
        }
    }

    static class ImageViewManager extends RenderableViewManager<ImageView> implements f1 {
        public static final String REACT_CLASS = "RNSVGImage";

        ImageViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGImage);
            this.mDelegate = new e1(this);
        }

        public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
            HashMap hashMap = new HashMap();
            hashMap.put(SvgLoadEvent.EVENT_NAME, f.d("registrationName", "onLoad"));
            return hashMap;
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "align")
        public void setAlign(ImageView imageView, String str) {
            imageView.setAlign(str);
        }

        @h7.a(name = "height")
        public void setHeight(ImageView imageView, Dynamic dynamic) {
            imageView.u(dynamic);
        }

        @h7.a(name = "meetOrSlice")
        public void setMeetOrSlice(ImageView imageView, int i10) {
            imageView.setMeetOrSlice(i10);
        }

        @h7.a(customType = "ImageSource", name = "src")
        public void setSrc(ImageView imageView, ReadableMap readableMap) {
            imageView.v(readableMap);
        }

        @h7.a(name = "width")
        public void setWidth(ImageView imageView, Dynamic dynamic) {
            imageView.w(dynamic);
        }

        @h7.a(name = "x")
        public void setX(ImageView imageView, Dynamic dynamic) {
            imageView.x(dynamic);
        }

        @h7.a(name = "y")
        public void setY(ImageView imageView, Dynamic dynamic) {
            imageView.y(dynamic);
        }
    }

    static class LineViewManager extends RenderableViewManager<LineView> implements h1 {
        public static final String REACT_CLASS = "RNSVGLine";

        LineViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGLine);
            this.mDelegate = new g1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "x1")
        public void setX1(LineView lineView, Dynamic dynamic) {
            lineView.p(dynamic);
        }

        @h7.a(name = "x2")
        public void setX2(LineView lineView, Dynamic dynamic) {
            lineView.q(dynamic);
        }

        @h7.a(name = "y1")
        public void setY1(LineView lineView, Dynamic dynamic) {
            lineView.r(dynamic);
        }

        @h7.a(name = "y2")
        public void setY2(LineView lineView, Dynamic dynamic) {
            lineView.s(dynamic);
        }
    }

    static class LinearGradientManager extends VirtualViewManager<LinearGradientView> implements j1 {
        public static final String REACT_CLASS = "RNSVGLinearGradient";

        LinearGradientManager() {
            super(VirtualViewManager.SVGClass.RNSVGLinearGradient);
            this.mDelegate = new i1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "gradient")
        public void setGradient(LinearGradientView linearGradientView, ReadableArray readableArray) {
            linearGradientView.p(readableArray);
        }

        @h7.a(name = "gradientTransform")
        public void setGradientTransform(LinearGradientView linearGradientView, ReadableArray readableArray) {
            linearGradientView.q(readableArray);
        }

        @h7.a(name = "gradientUnits")
        public void setGradientUnits(LinearGradientView linearGradientView, int i10) {
            linearGradientView.r(i10);
        }

        @h7.a(name = "x1")
        public void setX1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.s(dynamic);
        }

        @h7.a(name = "x2")
        public void setX2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.t(dynamic);
        }

        @h7.a(name = "y1")
        public void setY1(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.u(dynamic);
        }

        @h7.a(name = "y2")
        public void setY2(LinearGradientView linearGradientView, Dynamic dynamic) {
            linearGradientView.v(dynamic);
        }
    }

    static class MarkerManager extends GroupViewManagerAbstract<MarkerView> implements l1 {
        public static final String REACT_CLASS = "RNSVGMarker";

        MarkerManager() {
            super(VirtualViewManager.SVGClass.RNSVGMarker);
            this.mDelegate = new k1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((GroupView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "align")
        public void setAlign(MarkerView markerView, String str) {
            markerView.setAlign(str);
        }

        @h7.a(name = "markerHeight")
        public void setMarkerHeight(MarkerView markerView, Dynamic dynamic) {
            markerView.B(dynamic);
        }

        @h7.a(name = "markerUnits")
        public void setMarkerUnits(MarkerView markerView, String str) {
            markerView.C(str);
        }

        @h7.a(name = "markerWidth")
        public void setMarkerWidth(MarkerView markerView, Dynamic dynamic) {
            markerView.D(dynamic);
        }

        @h7.a(name = "meetOrSlice")
        public void setMeetOrSlice(MarkerView markerView, int i10) {
            markerView.setMeetOrSlice(i10);
        }

        @h7.a(name = "minX")
        public void setMinX(MarkerView markerView, float f10) {
            markerView.setMinX(f10);
        }

        @h7.a(name = "minY")
        public void setMinY(MarkerView markerView, float f10) {
            markerView.setMinY(f10);
        }

        @h7.a(name = "orient")
        public void setOrient(MarkerView markerView, String str) {
            markerView.E(str);
        }

        @h7.a(name = "refX")
        public void setRefX(MarkerView markerView, Dynamic dynamic) {
            markerView.F(dynamic);
        }

        @h7.a(name = "refY")
        public void setRefY(MarkerView markerView, Dynamic dynamic) {
            markerView.G(dynamic);
        }

        @h7.a(name = "vbHeight")
        public void setVbHeight(MarkerView markerView, float f10) {
            markerView.setVbHeight(f10);
        }

        @h7.a(name = "vbWidth")
        public void setVbWidth(MarkerView markerView, float f10) {
            markerView.setVbWidth(f10);
        }
    }

    static class MaskManager extends GroupViewManagerAbstract<MaskView> implements n1 {
        public static final String REACT_CLASS = "RNSVGMask";

        MaskManager() {
            super(VirtualViewManager.SVGClass.RNSVGMask);
            this.mDelegate = new m1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((GroupView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "height")
        public void setHeight(MaskView maskView, Dynamic dynamic) {
            maskView.C(dynamic);
        }

        @h7.a(name = "maskContentUnits")
        public void setMaskContentUnits(MaskView maskView, int i10) {
            maskView.D(i10);
        }

        @h7.a(name = "maskType")
        public void setMaskType(MaskView maskView, int i10) {
            maskView.E(i10);
        }

        @h7.a(name = "maskUnits")
        public void setMaskUnits(MaskView maskView, int i10) {
            maskView.F(i10);
        }

        @h7.a(name = "width")
        public void setWidth(MaskView maskView, Dynamic dynamic) {
            maskView.G(dynamic);
        }

        @h7.a(name = "x")
        public void setX(MaskView maskView, Dynamic dynamic) {
            maskView.H(dynamic);
        }

        @h7.a(name = "y")
        public void setY(MaskView maskView, Dynamic dynamic) {
            maskView.I(dynamic);
        }
    }

    static class PathViewManager extends RenderableViewManager<PathView> implements p1 {
        public static final String REACT_CLASS = "RNSVGPath";

        PathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGPath);
            this.mDelegate = new o1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "d")
        public void setD(PathView pathView, String str) {
            pathView.p(str);
        }
    }

    static class PatternManager extends GroupViewManagerAbstract<PatternView> implements r1 {
        public static final String REACT_CLASS = "RNSVGPattern";

        PatternManager() {
            super(VirtualViewManager.SVGClass.RNSVGPattern);
            this.mDelegate = new q1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((GroupView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "align")
        public void setAlign(PatternView patternView, String str) {
            patternView.setAlign(str);
        }

        @h7.a(name = "height")
        public void setHeight(PatternView patternView, Dynamic dynamic) {
            patternView.A(dynamic);
        }

        @h7.a(name = "meetOrSlice")
        public void setMeetOrSlice(PatternView patternView, int i10) {
            patternView.setMeetOrSlice(i10);
        }

        @h7.a(name = "minX")
        public void setMinX(PatternView patternView, float f10) {
            patternView.setMinX(f10);
        }

        @h7.a(name = "minY")
        public void setMinY(PatternView patternView, float f10) {
            patternView.setMinY(f10);
        }

        @h7.a(name = "patternContentUnits")
        public void setPatternContentUnits(PatternView patternView, int i10) {
            patternView.B(i10);
        }

        @h7.a(name = "patternTransform")
        public void setPatternTransform(PatternView patternView, ReadableArray readableArray) {
            patternView.C(readableArray);
        }

        @h7.a(name = "patternUnits")
        public void setPatternUnits(PatternView patternView, int i10) {
            patternView.D(i10);
        }

        @h7.a(name = "vbHeight")
        public void setVbHeight(PatternView patternView, float f10) {
            patternView.setVbHeight(f10);
        }

        @h7.a(name = "vbWidth")
        public void setVbWidth(PatternView patternView, float f10) {
            patternView.setVbWidth(f10);
        }

        @h7.a(name = "width")
        public void setWidth(PatternView patternView, Dynamic dynamic) {
            patternView.E(dynamic);
        }

        @h7.a(name = "x")
        public void setX(PatternView patternView, Dynamic dynamic) {
            patternView.F(dynamic);
        }

        @h7.a(name = "y")
        public void setY(PatternView patternView, Dynamic dynamic) {
            patternView.G(dynamic);
        }
    }

    static class RadialGradientManager extends VirtualViewManager<RadialGradientView> implements t1 {
        public static final String REACT_CLASS = "RNSVGRadialGradient";

        RadialGradientManager() {
            super(VirtualViewManager.SVGClass.RNSVGRadialGradient);
            this.mDelegate = new s1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "cx")
        public void setCx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.p(dynamic);
        }

        @h7.a(name = "cy")
        public void setCy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.q(dynamic);
        }

        @h7.a(name = "fx")
        public void setFx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.r(dynamic);
        }

        @h7.a(name = "fy")
        public void setFy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.s(dynamic);
        }

        @h7.a(name = "gradient")
        public void setGradient(RadialGradientView radialGradientView, ReadableArray readableArray) {
            radialGradientView.t(readableArray);
        }

        @h7.a(name = "gradientTransform")
        public void setGradientTransform(RadialGradientView radialGradientView, ReadableArray readableArray) {
            radialGradientView.u(readableArray);
        }

        @h7.a(name = "gradientUnits")
        public void setGradientUnits(RadialGradientView radialGradientView, int i10) {
            radialGradientView.v(i10);
        }

        @h7.a(name = "rx")
        public void setRx(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.w(dynamic);
        }

        @h7.a(name = "ry")
        public void setRy(RadialGradientView radialGradientView, Dynamic dynamic) {
            radialGradientView.x(dynamic);
        }
    }

    static class RectViewManager extends RenderableViewManager<RectView> implements v1 {
        public static final String REACT_CLASS = "RNSVGRect";

        RectViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGRect);
            this.mDelegate = new u1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "height")
        public void setHeight(RectView rectView, Dynamic dynamic) {
            rectView.p(dynamic);
        }

        @h7.a(name = "rx")
        public void setRx(RectView rectView, Dynamic dynamic) {
            rectView.q(dynamic);
        }

        @h7.a(name = "ry")
        public void setRy(RectView rectView, Dynamic dynamic) {
            rectView.r(dynamic);
        }

        @h7.a(name = "width")
        public void setWidth(RectView rectView, Dynamic dynamic) {
            rectView.s(dynamic);
        }

        @h7.a(name = "x")
        public void setX(RectView rectView, Dynamic dynamic) {
            rectView.t(dynamic);
        }

        @h7.a(name = "y")
        public void setY(RectView rectView, Dynamic dynamic) {
            rectView.u(dynamic);
        }
    }

    static class SymbolManager extends GroupViewManagerAbstract<SymbolView> implements z1 {
        public static final String REACT_CLASS = "RNSVGSymbol";

        SymbolManager() {
            super(VirtualViewManager.SVGClass.RNSVGSymbol);
            this.mDelegate = new y1(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((GroupView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "align")
        public void setAlign(SymbolView symbolView, String str) {
            symbolView.setAlign(str);
        }

        @h7.a(name = "meetOrSlice")
        public void setMeetOrSlice(SymbolView symbolView, int i10) {
            symbolView.setMeetOrSlice(i10);
        }

        @h7.a(name = "minX")
        public void setMinX(SymbolView symbolView, float f10) {
            symbolView.setMinX(f10);
        }

        @h7.a(name = "minY")
        public void setMinY(SymbolView symbolView, float f10) {
            symbolView.setMinY(f10);
        }

        @h7.a(name = "vbHeight")
        public void setVbHeight(SymbolView symbolView, float f10) {
            symbolView.setVbHeight(f10);
        }

        @h7.a(name = "vbWidth")
        public void setVbWidth(SymbolView symbolView, float f10) {
            symbolView.setVbWidth(f10);
        }
    }

    static class TSpanViewManager extends TextViewManagerAbstract<TSpanView> implements b2 {
        public static final String REACT_CLASS = "RNSVGTSpan";

        TSpanViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGTSpan);
            this.mDelegate = new a2(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, String str) {
            super.setAlignmentBaseline((TextView) view, str);
        }

        @h7.a(name = "baselineShift")
        public /* bridge */ /* synthetic */ void setBaselineShift(View view, Dynamic dynamic) {
            super.setBaselineShift((TextView) view, dynamic);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "dx")
        public /* bridge */ /* synthetic */ void setDx(View view, Dynamic dynamic) {
            super.setDx((TextView) view, dynamic);
        }

        @h7.a(name = "dy")
        public /* bridge */ /* synthetic */ void setDy(View view, Dynamic dynamic) {
            super.setDy((TextView) view, dynamic);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((TextView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "inlineSize")
        public /* bridge */ /* synthetic */ void setInlineSize(View view, Dynamic dynamic) {
            super.setInlineSize((TextView) view, dynamic);
        }

        @h7.a(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, String str) {
            super.setLengthAdjust((TextView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "rotate")
        public /* bridge */ /* synthetic */ void setRotate(View view, Dynamic dynamic) {
            super.setRotate((TextView) view, dynamic);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "textLength")
        public /* bridge */ /* synthetic */ void setTextLength(View view, Dynamic dynamic) {
            super.setTextLength((TextView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, Dynamic dynamic) {
            super.setVerticalAlign((TextView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((TextView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((TextView) view, dynamic);
        }

        @h7.a(name = "content")
        public void setContent(TSpanView tSpanView, String str) {
            tSpanView.Y(str);
        }

        TSpanViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new a2(this);
        }
    }

    static class TextPathViewManager extends TextViewManagerAbstract<TextPathView> implements f2 {
        public static final String REACT_CLASS = "RNSVGTextPath";

        TextPathViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGTextPath);
            this.mDelegate = new e2(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, String str) {
            super.setAlignmentBaseline((TextView) view, str);
        }

        @h7.a(name = "baselineShift")
        public /* bridge */ /* synthetic */ void setBaselineShift(View view, Dynamic dynamic) {
            super.setBaselineShift((TextView) view, dynamic);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "dx")
        public /* bridge */ /* synthetic */ void setDx(View view, Dynamic dynamic) {
            super.setDx((TextView) view, dynamic);
        }

        @h7.a(name = "dy")
        public /* bridge */ /* synthetic */ void setDy(View view, Dynamic dynamic) {
            super.setDy((TextView) view, dynamic);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((TextView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "inlineSize")
        public /* bridge */ /* synthetic */ void setInlineSize(View view, Dynamic dynamic) {
            super.setInlineSize((TextView) view, dynamic);
        }

        @h7.a(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, String str) {
            super.setLengthAdjust((TextView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "rotate")
        public /* bridge */ /* synthetic */ void setRotate(View view, Dynamic dynamic) {
            super.setRotate((TextView) view, dynamic);
        }

        @h7.a(name = "midLine")
        public void setSharp(TextPathView textPathView, String str) {
            textPathView.W(str);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "textLength")
        public /* bridge */ /* synthetic */ void setTextLength(View view, Dynamic dynamic) {
            super.setTextLength((TextView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, Dynamic dynamic) {
            super.setVerticalAlign((TextView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((TextView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((TextView) view, dynamic);
        }

        @h7.a(name = "href")
        public void setHref(TextPathView textPathView, String str) {
            textPathView.V(str);
        }

        public void setMidLine(TextPathView textPathView, String str) {
            textPathView.W(str);
        }

        @h7.a(name = "side")
        public void setSide(TextPathView textPathView, String str) {
            textPathView.X(str);
        }

        @h7.a(name = "spacing")
        public void setSpacing(TextPathView textPathView, String str) {
            textPathView.Y(str);
        }

        @h7.a(name = "startOffset")
        public void setStartOffset(TextPathView textPathView, Dynamic dynamic) {
            textPathView.Z(dynamic);
        }

        TextPathViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new e2(this);
        }

        @h7.a(name = "method")
        public void setMethod(TextPathView textPathView, String str) {
            textPathView.L(str);
        }
    }

    static class TextViewManagerAbstract<K extends TextView> extends GroupViewManagerAbstract<K> {
        TextViewManagerAbstract(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        public void setAlignmentBaseline(K k10, String str) {
            k10.L(str);
        }

        @h7.a(name = "baselineShift")
        public void setBaselineShift(K k10, Dynamic dynamic) {
            k10.G(dynamic);
        }

        @h7.a(name = "dx")
        public void setDx(K k10, Dynamic dynamic) {
            k10.H(dynamic);
        }

        @h7.a(name = "dy")
        public void setDy(K k10, Dynamic dynamic) {
            k10.I(dynamic);
        }

        @h7.a(name = "inlineSize")
        public void setInlineSize(K k10, Dynamic dynamic) {
            k10.J(dynamic);
        }

        @h7.a(name = "lengthAdjust")
        public void setLengthAdjust(K k10, String str) {
            k10.K(str);
        }

        @h7.a(name = "alignmentBaseline")
        public void setMethod(K k10, String str) {
            k10.L(str);
        }

        @h7.a(name = "rotate")
        public void setRotate(K k10, Dynamic dynamic) {
            k10.O(dynamic);
        }

        @h7.a(name = "textLength")
        public void setTextLength(K k10, Dynamic dynamic) {
            k10.P(dynamic);
        }

        @h7.a(name = "verticalAlign")
        public void setVerticalAlign(K k10, Dynamic dynamic) {
            k10.Q(dynamic);
        }

        @h7.a(name = "x")
        public void setX(K k10, Dynamic dynamic) {
            k10.M(dynamic);
        }

        @h7.a(name = "y")
        public void setY(K k10, Dynamic dynamic) {
            k10.N(dynamic);
        }

        @h7.a(name = "font")
        public void setFont(K k10, Dynamic dynamic) {
            k10.x(dynamic);
        }
    }

    static class UseViewManager extends RenderableViewManager<UseView> implements h2 {
        public static final String REACT_CLASS = "RNSVGUse";

        UseViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGUse);
            this.mDelegate = new g2(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "height")
        public void setHeight(UseView useView, Dynamic dynamic) {
            useView.p(dynamic);
        }

        @h7.a(name = "href")
        public void setHref(UseView useView, String str) {
            useView.q(str);
        }

        @h7.a(name = "width")
        public void setWidth(UseView useView, Dynamic dynamic) {
            useView.r(dynamic);
        }

        @h7.a(name = "x")
        public void setX(UseView useView, Dynamic dynamic) {
            useView.s(dynamic);
        }

        @h7.a(name = "y")
        public void setY(UseView useView, Dynamic dynamic) {
            useView.t(dynamic);
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9682a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9682a = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9682a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.RenderableViewManager.a.<clinit>():void");
        }
    }

    RenderableViewManager(VirtualViewManager.SVGClass sVGClass) {
        super(sVGClass);
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    @h7.a(customType = "Color", name = "color")
    public void setColor(T t10, Integer num) {
        t10.setCurrentColor(num);
    }

    @h7.a(name = "fill")
    public void setFill(T t10, Dynamic dynamic) {
        t10.setFill(dynamic);
    }

    @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(T t10, float f10) {
        t10.setFillOpacity(f10);
    }

    @h7.a(defaultInt = 1, name = "fillRule")
    public void setFillRule(T t10, int i10) {
        t10.setFillRule(i10);
    }

    @h7.a(name = "filter")
    public void setFilter(T t10, String str) {
        t10.setFilter(str);
    }

    @h7.a(name = "propList")
    public void setPropList(T t10, ReadableArray readableArray) {
        t10.setPropList(readableArray);
    }

    @h7.a(name = "stroke")
    public void setStroke(T t10, Dynamic dynamic) {
        t10.setStroke(dynamic);
    }

    @h7.a(name = "strokeDasharray")
    public void setStrokeDasharray(T t10, Dynamic dynamic) {
        t10.setStrokeDasharray(dynamic);
    }

    @h7.a(name = "strokeDashoffset")
    public void setStrokeDashoffset(T t10, float f10) {
        t10.setStrokeDashoffset(f10);
    }

    @h7.a(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(T t10, int i10) {
        t10.setStrokeLinecap(i10);
    }

    @h7.a(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(T t10, int i10) {
        t10.setStrokeLinejoin(i10);
    }

    @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(T t10, float f10) {
        t10.setStrokeMiterlimit(f10);
    }

    @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(T t10, float f10) {
        t10.setStrokeOpacity(f10);
    }

    @h7.a(name = "strokeWidth")
    public void setStrokeWidth(T t10, Dynamic dynamic) {
        t10.setStrokeWidth(dynamic);
    }

    @h7.a(name = "vectorEffect")
    public void setVectorEffect(T t10, int i10) {
        t10.setVectorEffect(i10);
    }

    static class TextViewManager extends TextViewManagerAbstract<TextView> implements d2 {
        public static final String REACT_CLASS = "RNSVGText";

        TextViewManager() {
            super(VirtualViewManager.SVGClass.RNSVGText);
            this.mDelegate = new c2(this);
        }

        public /* bridge */ /* synthetic */ void removeAllViews(View view) {
            p.a(this, view);
        }

        public /* bridge */ /* synthetic */ void setAlignmentBaseline(View view, String str) {
            super.setAlignmentBaseline((TextView) view, str);
        }

        @h7.a(name = "baselineShift")
        public /* bridge */ /* synthetic */ void setBaselineShift(View view, Dynamic dynamic) {
            super.setBaselineShift((TextView) view, dynamic);
        }

        @h7.a(name = "clipPath")
        public /* bridge */ /* synthetic */ void setClipPath(View view, String str) {
            super.setClipPath((VirtualView) view, str);
        }

        @h7.a(name = "clipRule")
        public /* bridge */ /* synthetic */ void setClipRule(View view, int i10) {
            super.setClipRule((VirtualView) view, i10);
        }

        @h7.a(customType = "Color", name = "color")
        public /* bridge */ /* synthetic */ void setColor(View view, Integer num) {
            RenderableViewManager.super.setColor((RenderableView) view, num);
        }

        @h7.a(name = "display")
        public /* bridge */ /* synthetic */ void setDisplay(View view, String str) {
            super.setDisplay((VirtualView) view, str);
        }

        @h7.a(name = "dx")
        public /* bridge */ /* synthetic */ void setDx(View view, Dynamic dynamic) {
            super.setDx((TextView) view, dynamic);
        }

        @h7.a(name = "dy")
        public /* bridge */ /* synthetic */ void setDy(View view, Dynamic dynamic) {
            super.setDy((TextView) view, dynamic);
        }

        @h7.a(name = "fill")
        public /* bridge */ /* synthetic */ void setFill(View view, Dynamic dynamic) {
            RenderableViewManager.super.setFill((RenderableView) view, dynamic);
        }

        @h7.a(defaultFloat = 1.0f, name = "fillOpacity")
        public /* bridge */ /* synthetic */ void setFillOpacity(View view, float f10) {
            RenderableViewManager.super.setFillOpacity((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "fillRule")
        public /* bridge */ /* synthetic */ void setFillRule(View view, int i10) {
            RenderableViewManager.super.setFillRule((RenderableView) view, i10);
        }

        @h7.a(name = "filter")
        public /* bridge */ /* synthetic */ void setFilter(View view, String str) {
            RenderableViewManager.super.setFilter((RenderableView) view, str);
        }

        @h7.a(name = "font")
        public /* bridge */ /* synthetic */ void setFont(View view, Dynamic dynamic) {
            super.setFont((TextView) view, dynamic);
        }

        @h7.a(name = "fontSize")
        public /* bridge */ /* synthetic */ void setFontSize(View view, Dynamic dynamic) {
            super.setFontSize((GroupView) view, dynamic);
        }

        @h7.a(name = "fontWeight")
        public /* bridge */ /* synthetic */ void setFontWeight(View view, Dynamic dynamic) {
            super.setFontWeight((GroupView) view, dynamic);
        }

        @h7.a(name = "inlineSize")
        public /* bridge */ /* synthetic */ void setInlineSize(View view, Dynamic dynamic) {
            super.setInlineSize((TextView) view, dynamic);
        }

        @h7.a(name = "lengthAdjust")
        public /* bridge */ /* synthetic */ void setLengthAdjust(View view, String str) {
            super.setLengthAdjust((TextView) view, str);
        }

        @h7.a(name = "markerEnd")
        public /* bridge */ /* synthetic */ void setMarkerEnd(View view, String str) {
            super.setMarkerEnd((VirtualView) view, str);
        }

        @h7.a(name = "markerMid")
        public /* bridge */ /* synthetic */ void setMarkerMid(View view, String str) {
            super.setMarkerMid((VirtualView) view, str);
        }

        @h7.a(name = "markerStart")
        public /* bridge */ /* synthetic */ void setMarkerStart(View view, String str) {
            super.setMarkerStart((VirtualView) view, str);
        }

        @h7.a(name = "mask")
        public /* bridge */ /* synthetic */ void setMask(View view, String str) {
            super.setMask((VirtualView) view, str);
        }

        public /* bridge */ /* synthetic */ void setMatrix(View view, ReadableArray readableArray) {
            super.setMatrix((VirtualView) view, readableArray);
        }

        @h7.a(name = "name")
        public /* bridge */ /* synthetic */ void setName(View view, String str) {
            super.setName((VirtualView) view, str);
        }

        @h7.a(defaultFloat = 1.0f, name = "opacity")
        public /* bridge */ /* synthetic */ void setOpacity(View view, float f10) {
            super.setOpacity((VirtualView) view, f10);
        }

        @h7.a(name = "pointerEvents")
        public /* bridge */ /* synthetic */ void setPointerEvents(View view, String str) {
            super.setPointerEvents((VirtualView) view, str);
        }

        @h7.a(name = "propList")
        public /* bridge */ /* synthetic */ void setPropList(View view, ReadableArray readableArray) {
            RenderableViewManager.super.setPropList((RenderableView) view, readableArray);
        }

        @h7.a(name = "responsible")
        public /* bridge */ /* synthetic */ void setResponsible(View view, boolean z10) {
            super.setResponsible((VirtualView) view, z10);
        }

        @h7.a(name = "rotate")
        public /* bridge */ /* synthetic */ void setRotate(View view, Dynamic dynamic) {
            super.setRotate((TextView) view, dynamic);
        }

        @h7.a(name = "stroke")
        public /* bridge */ /* synthetic */ void setStroke(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStroke((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDasharray")
        public /* bridge */ /* synthetic */ void setStrokeDasharray(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeDasharray((RenderableView) view, dynamic);
        }

        @h7.a(name = "strokeDashoffset")
        public /* bridge */ /* synthetic */ void setStrokeDashoffset(View view, float f10) {
            RenderableViewManager.super.setStrokeDashoffset((RenderableView) view, f10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinecap")
        public /* bridge */ /* synthetic */ void setStrokeLinecap(View view, int i10) {
            RenderableViewManager.super.setStrokeLinecap((RenderableView) view, i10);
        }

        @h7.a(defaultInt = 1, name = "strokeLinejoin")
        public /* bridge */ /* synthetic */ void setStrokeLinejoin(View view, int i10) {
            RenderableViewManager.super.setStrokeLinejoin((RenderableView) view, i10);
        }

        @h7.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
        public /* bridge */ /* synthetic */ void setStrokeMiterlimit(View view, float f10) {
            RenderableViewManager.super.setStrokeMiterlimit((RenderableView) view, f10);
        }

        @h7.a(defaultFloat = 1.0f, name = "strokeOpacity")
        public /* bridge */ /* synthetic */ void setStrokeOpacity(View view, float f10) {
            RenderableViewManager.super.setStrokeOpacity((RenderableView) view, f10);
        }

        @h7.a(name = "strokeWidth")
        public /* bridge */ /* synthetic */ void setStrokeWidth(View view, Dynamic dynamic) {
            RenderableViewManager.super.setStrokeWidth((RenderableView) view, dynamic);
        }

        @h7.a(name = "textLength")
        public /* bridge */ /* synthetic */ void setTextLength(View view, Dynamic dynamic) {
            super.setTextLength((TextView) view, dynamic);
        }

        @h7.a(name = "vectorEffect")
        public /* bridge */ /* synthetic */ void setVectorEffect(View view, int i10) {
            RenderableViewManager.super.setVectorEffect((RenderableView) view, i10);
        }

        @h7.a(name = "verticalAlign")
        public /* bridge */ /* synthetic */ void setVerticalAlign(View view, Dynamic dynamic) {
            super.setVerticalAlign((TextView) view, dynamic);
        }

        @h7.a(name = "x")
        public /* bridge */ /* synthetic */ void setX(View view, Dynamic dynamic) {
            super.setX((TextView) view, dynamic);
        }

        @h7.a(name = "y")
        public /* bridge */ /* synthetic */ void setY(View view, Dynamic dynamic) {
            super.setY((TextView) view, dynamic);
        }

        TextViewManager(VirtualViewManager.SVGClass sVGClass) {
            super(sVGClass);
            this.mDelegate = new c2(this);
        }
    }

    public void setFill(T t10, ReadableMap readableMap) {
        t10.setFill(readableMap);
    }

    public void setStroke(T t10, ReadableMap readableMap) {
        t10.setStroke(readableMap);
    }
}
