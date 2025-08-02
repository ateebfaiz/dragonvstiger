package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.work.WorkRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzhf;
import com.google.android.gms.internal.measurement.zzhq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
public final class zzdu {
    public static final zzdt zzA = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbi.zza);
    public static final zzdt zzB = zza("measurement.upload.retry_count", 6, 6, zzbk.zza);
    public static final zzdt zzC = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbl.zza);
    public static final zzdt zzD = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbm.zza);
    public static final zzdt zzE = zza("measurement.audience.filter_result_max_count", 200, 200, zzbo.zza);
    public static final zzdt zzF = zza("measurement.upload.max_public_user_properties", 25, 25, (m) null);
    public static final zzdt zzG = zza("measurement.upload.max_event_name_cardinality", 500, 500, (m) null);
    public static final zzdt zzH = zza("measurement.upload.max_public_event_params", 25, 25, (m) null);
    public static final zzdt zzI = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbp.zza);
    public static final zzdt zzJ;
    public static final zzdt zzK = zza("measurement.test.string_flag", "---", "---", zzbr.zza);
    public static final zzdt zzL = zza("measurement.test.long_flag", -1L, -1L, zzbs.zza);
    public static final zzdt zzM = zza("measurement.test.int_flag", -2, -2, zzbt.zza);
    public static final zzdt zzN;
    public static final zzdt zzO = zza("measurement.experiment.max_ids", 50, 50, zzbw.zza);
    public static final zzdt zzP = zza("measurement.max_bundles_per_iteration", 100, 100, zzbx.zza);
    public static final zzdt zzQ = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzby.zza);
    public static final zzdt zzR = zza("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, zzca.zza);
    public static final zzdt zzS;
    public static final zzdt zzT;
    public static final zzdt zzU;
    public static final zzdt zzV;
    public static final zzdt zzW;
    public static final zzdt zzX;
    public static final zzdt zzY;
    public static final zzdt zzZ;
    public static final zzdt zza;
    public static final zzdt zzaa;
    public static final zzdt zzab;
    public static final zzdt zzac;
    public static final zzdt zzad;
    public static final zzdt zzae;
    public static final zzdt zzaf = zza("measurement.service.storage_consent_support_version", 203600, 203600, zzcp.zza);
    public static final zzdt zzag;
    public static final zzdt zzah;
    public static final zzdt zzai;
    public static final zzdt zzaj;
    public static final zzdt zzak;
    public static final zzdt zzal;
    public static final zzdt zzam;
    public static final zzdt zzan;
    public static final zzdt zzao;
    public static final zzdt zzap;
    public static final zzdt zzaq;
    public static final zzdt zzar;
    public static final zzdt zzas;
    public static final zzdt zzat;
    public static final zzdt zzau;
    /* access modifiers changed from: private */
    public static final List zzav = Collections.synchronizedList(new ArrayList());
    private static final Set zzaw = Collections.synchronizedSet(new HashSet());
    public static final zzdt zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzbb.zza);
    public static final zzdt zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbn.zza);
    public static final zzdt zzd = zza("measurement.config.url_scheme", "https", "https", zzbz.zza);
    public static final zzdt zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcl.zza);
    public static final zzdt zzf = zza("measurement.upload.max_bundles", 100, 100, zzcx.zza);
    public static final zzdt zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzdi.zza);
    public static final zzdt zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdj.zza);
    public static final zzdt zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzdk.zza);
    public static final zzdt zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzdl.zza);
    public static final zzdt zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzbu.zza);
    public static final zzdt zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzcf.zza);
    public static final zzdt zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzcq.zza);
    public static final zzdt zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzdb.zza);
    public static final zzdt zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzdm.zza);
    public static final zzdt zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzdn.zza);
    public static final zzdt zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzdo.zza);
    public static final zzdt zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzdp.zza);
    public static final zzdt zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzaz.zza);
    public static final zzdt zzt;
    public static final zzdt zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbc.zza);
    public static final zzdt zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbd.zza);
    public static final zzdt zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbe.zza);
    public static final zzdt zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbf.zza);
    public static final zzdt zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbg.zza);
    public static final zzdt zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbh.zza);

    static {
        Long valueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        zza = zza("measurement.ad_id_cache_time", valueOf, valueOf, zzbj.zza);
        zzt = zza("measurement.upload.realtime_upload_interval", valueOf, valueOf, zzba.zza);
        Boolean bool = Boolean.FALSE;
        zzJ = zza("measurement.test.boolean_flag", bool, bool, zzbq.zza);
        Double valueOf2 = Double.valueOf(-3.0d);
        zzN = zza("measurement.test.double_flag", valueOf2, valueOf2, zzbv.zza);
        Boolean bool2 = Boolean.TRUE;
        zzS = zza("measurement.collection.log_event_and_bundle_v2", bool2, bool2, zzcb.zza);
        zzT = zza("measurement.quality.checksum", bool, bool, (m) null);
        zzU = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, zzcc.zza);
        zzV = zza("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, zzcd.zza);
        zzW = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, zzce.zza);
        zzX = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, zzcg.zza);
        zzY = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, zzch.zza);
        zzZ = zza("measurement.lifecycle.app_in_background_parameter", bool, bool, zzci.zza);
        zzaa = zza("measurement.integration.disable_firebase_instance_id", bool, bool, zzcj.zza);
        zzab = zza("measurement.collection.service.update_with_analytics_fix", bool, bool, zzck.zza);
        zzac = zza("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, zzcm.zza);
        zzad = zza("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, zzcn.zza);
        zzae = zza("measurement.collection.synthetic_data_mitigation", bool, bool, zzco.zza);
        zzag = zza("measurement.client.click_identifier_control.dev", bool, bool, zzcr.zza);
        zzah = zza("measurement.service.click_identifier_control", bool, bool, zzcs.zza);
        zzai = zza("measurement.service.store_null_safelist", bool2, bool2, zzct.zza);
        zzaj = zza("measurement.service.store_safelist", bool2, bool2, zzcu.zza);
        zzak = zza("measurement.collection.enable_session_stitching_token.service", bool, bool, zzcv.zza);
        zzal = zza("measurement.collection.enable_session_stitching_token.service_new", bool2, bool2, zzcw.zza);
        zzam = zza("measurement.collection.enable_session_stitching_token.client.dev", bool2, bool2, zzcy.zza);
        zzan = zza("measurement.session_stitching_token_enabled", bool, bool, zzcz.zza);
        zzao = zza("measurement.redaction.e_tag", bool2, bool2, zzda.zza);
        zzap = zza("measurement.redaction.client_ephemeral_aiid_generation", bool2, bool2, zzdc.zza);
        zzaq = zza("measurement.redaction.retain_major_os_version", bool2, bool2, zzdd.zza);
        zzar = zza("measurement.redaction.scion_payload_generator", bool2, bool2, zzde.zza);
        zzas = zza("measurement.audience.dynamic_filters.oob_fix", bool2, bool2, zzdf.zza);
        zzat = zza("measurement.service.clear_global_params_on_uninstall", bool2, bool2, zzdg.zza);
        zzau = zza("measurement.sessionid.enable_client_session_id", bool2, bool2, zzdh.zza);
    }

    @VisibleForTesting
    static zzdt zza(String str, Object obj, Object obj2, m mVar) {
        zzdt zzdt = new zzdt(str, obj, obj2, mVar, (zzds) null);
        zzav.add(zzdt);
        return zzdt;
    }

    public static Map zzc(Context context) {
        zzhf zza2 = zzhf.zza(context.getContentResolver(), zzhq.zza("com.google.android.gms.measurement"), zzay.zza);
        if (zza2 == null) {
            return Collections.emptyMap();
        }
        return zza2.zzc();
    }
}
