package androidx.exifinterface.media;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.a;
import androidx.work.WorkRequest;
import com.alibaba.pdns.o;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.cocos2dx.javascript.PlatformUtils;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final e[] EXIF_POINTER_TAGS;
    static final e[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(new Integer[]{2, 7, 4, 5});
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final Pattern GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
    private static final byte[] HEIF_BRAND_HEIC = {104, 101, 105, 99};
    private static final byte[] HEIF_BRAND_MIF1 = {109, 105, 102, 49};
    private static final byte[] HEIF_TYPE_FTYP = {102, 116, 121, 112};
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final e[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final e[] IFD_GPS_TAGS;
    private static final e[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final e[] IFD_THUMBNAIL_TAGS;
    private static final e[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    static final int IMAGE_TYPE_ARW = 1;
    static final int IMAGE_TYPE_CR2 = 2;
    static final int IMAGE_TYPE_DNG = 3;
    static final int IMAGE_TYPE_HEIF = 12;
    static final int IMAGE_TYPE_JPEG = 4;
    static final int IMAGE_TYPE_NEF = 5;
    static final int IMAGE_TYPE_NRW = 6;
    static final int IMAGE_TYPE_ORF = 7;
    static final int IMAGE_TYPE_PEF = 8;
    static final int IMAGE_TYPE_PNG = 13;
    static final int IMAGE_TYPE_RAF = 9;
    static final int IMAGE_TYPE_RW2 = 10;
    static final int IMAGE_TYPE_SRW = 11;
    static final int IMAGE_TYPE_UNKNOWN = 0;
    static final int IMAGE_TYPE_WEBP = 14;
    static final byte[] JPEG_SIGNATURE = {MARKER, MARKER_SOI, MARKER};
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final Pattern NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
    private static final e[] ORF_CAMERA_SETTINGS_TAGS;
    private static final e[] ORF_IMAGE_PROCESSING_TAGS;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final e[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final e[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] PNG_CHUNK_TYPE_EXIF = {101, 88, 73, 102};
    private static final byte[] PNG_CHUNK_TYPE_IEND = {73, 69, 78, 68};
    private static final byte[] PNG_CHUNK_TYPE_IHDR = {73, 72, 68, 82};
    private static final byte[] PNG_SIGNATURE = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(new Integer[]{1, 6, 3, 8});
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    private static final int SKIP_BUFFER_SIZE = 8192;
    static final byte START_CODE = 42;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final e TAG_RAF_IMAGE_SIZE;
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_EXIF = {69, 88, 73, 70};
    private static final byte[] WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_SIGNATURE_1 = {82, 73, 70, 70};
    private static final byte[] WEBP_SIGNATURE_2 = {87, 69, 66, 80};
    private static final byte WEBP_VP8L_SIGNATURE = 47;
    private static final byte[] WEBP_VP8_SIGNATURE = {-99, 1, START_CODE};
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();
    private static final HashMap<Integer, e>[] sExifTagMapsForReading;
    private static final HashMap<String, e>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP}));
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, d>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExifStreamType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    class a extends MediaDataSource {

        /* renamed from: a  reason: collision with root package name */
        long f15499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f15500b;

        a(g gVar) {
            this.f15500b = gVar;
        }

        public void close() {
        }

        public long getSize() {
            return -1;
        }

        public int readAt(long j10, byte[] bArr, int i10, int i11) {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f15499a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + ((long) this.f15500b.available())) {
                        return -1;
                    }
                    this.f15500b.k(j10);
                    this.f15499a = j10;
                }
                if (i11 > this.f15500b.available()) {
                    i11 = this.f15500b.available();
                }
                int read = this.f15500b.read(bArr, i10, i11);
                if (read >= 0) {
                    this.f15499a += (long) read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f15499a = -1;
            return -1;
        }
    }

    private static class b extends InputStream implements DataInput {

        /* renamed from: e  reason: collision with root package name */
        private static final ByteOrder f15502e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f  reason: collision with root package name */
        private static final ByteOrder f15503f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        final DataInputStream f15504a;

        /* renamed from: b  reason: collision with root package name */
        private ByteOrder f15505b;

        /* renamed from: c  reason: collision with root package name */
        int f15506c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f15507d;

        b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f15506c;
        }

        public int available() {
            return this.f15504a.available();
        }

        public long b() {
            return ((long) readInt()) & 4294967295L;
        }

        public void h(ByteOrder byteOrder) {
            this.f15505b = byteOrder;
        }

        public void j(int i10) {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int skip = (int) this.f15504a.skip((long) i12);
                if (skip <= 0) {
                    if (this.f15507d == null) {
                        this.f15507d = new byte[8192];
                    }
                    skip = this.f15504a.read(this.f15507d, 0, Math.min(8192, i12));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += skip;
            }
            this.f15506c += i11;
        }

        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int read() {
            this.f15506c++;
            return this.f15504a.read();
        }

        public boolean readBoolean() {
            this.f15506c++;
            return this.f15504a.readBoolean();
        }

        public byte readByte() {
            this.f15506c++;
            int read = this.f15504a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() {
            this.f15506c += 2;
            return this.f15504a.readChar();
        }

        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i10, int i11) {
            this.f15506c += i11;
            this.f15504a.readFully(bArr, i10, i11);
        }

        public int readInt() {
            this.f15506c += 4;
            int read = this.f15504a.read();
            int read2 = this.f15504a.read();
            int read3 = this.f15504a.read();
            int read4 = this.f15504a.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f15505b;
                if (byteOrder == f15502e) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f15503f) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f15505b);
            }
            throw new EOFException();
        }

        public String readLine() {
            Log.d(ExifInterface.TAG, "Currently unsupported");
            return null;
        }

        public long readLong() {
            this.f15506c += 8;
            int read = this.f15504a.read();
            int read2 = this.f15504a.read();
            int read3 = this.f15504a.read();
            int read4 = this.f15504a.read();
            int read5 = this.f15504a.read();
            int read6 = this.f15504a.read();
            int read7 = this.f15504a.read();
            int read8 = this.f15504a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f15505b;
                if (byteOrder == f15502e) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i10 = read2;
                if (byteOrder == f15503f) {
                    return (((long) read) << 56) + (((long) i10) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.f15505b);
            }
            throw new EOFException();
        }

        public short readShort() {
            this.f15506c += 2;
            int read = this.f15504a.read();
            int read2 = this.f15504a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f15505b;
                if (byteOrder == f15502e) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f15503f) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f15505b);
            }
            throw new EOFException();
        }

        public String readUTF() {
            this.f15506c += 2;
            return this.f15504a.readUTF();
        }

        public int readUnsignedByte() {
            this.f15506c++;
            return this.f15504a.readUnsignedByte();
        }

        public int readUnsignedShort() {
            this.f15506c += 2;
            int read = this.f15504a.read();
            int read2 = this.f15504a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f15505b;
                if (byteOrder == f15502e) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f15503f) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f15505b);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public int skipBytes(int i10) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) {
            this.f15505b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f15504a = dataInputStream;
            dataInputStream.mark(0);
            this.f15506c = 0;
            this.f15505b = byteOrder;
        }

        public int read(byte[] bArr, int i10, int i11) {
            int read = this.f15504a.read(bArr, i10, i11);
            this.f15506c += read;
            return read;
        }

        public void readFully(byte[] bArr) {
            this.f15506c += bArr.length;
            this.f15504a.readFully(bArr);
        }
    }

    private static class c extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        final OutputStream f15508a;

        /* renamed from: b  reason: collision with root package name */
        private ByteOrder f15509b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f15508a = outputStream;
            this.f15509b = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f15509b = byteOrder;
        }

        public void b(int i10) {
            this.f15508a.write(i10);
        }

        public void h(int i10) {
            ByteOrder byteOrder = this.f15509b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f15508a.write(i10 & 255);
                this.f15508a.write((i10 >>> 8) & 255);
                this.f15508a.write((i10 >>> 16) & 255);
                this.f15508a.write((i10 >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f15508a.write((i10 >>> 24) & 255);
                this.f15508a.write((i10 >>> 16) & 255);
                this.f15508a.write((i10 >>> 8) & 255);
                this.f15508a.write(i10 & 255);
            }
        }

        public void j(short s10) {
            ByteOrder byteOrder = this.f15509b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f15508a.write(s10 & 255);
                this.f15508a.write((s10 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f15508a.write((s10 >>> 8) & 255);
                this.f15508a.write(s10 & 255);
            }
        }

        public void k(long j10) {
            h((int) j10);
        }

        public void m(int i10) {
            j((short) i10);
        }

        public void write(byte[] bArr) {
            this.f15508a.write(bArr);
        }

        public void write(byte[] bArr, int i10, int i11) {
            this.f15508a.write(bArr, i10, i11);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f15510a;

        /* renamed from: b  reason: collision with root package name */
        public final int f15511b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15512c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f15513d;

        d(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1, bArr);
        }

        public static d a(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes = str.getBytes(ExifInterface.ASCII);
                return new d(1, bytes.length, bytes);
            }
            return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new d(12, dArr.length, wrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new d(9, iArr.length, wrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f15518a);
                wrap.putInt((int) fVar.f15519b);
            }
            return new d(10, fVarArr.length, wrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + 0).getBytes(ExifInterface.ASCII);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j10, ByteOrder byteOrder) {
            return g(new long[]{j10}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j10 : jArr) {
                wrap.putInt((int) j10);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f15518a);
                wrap.putInt((int) fVar.f15519b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public static d j(int i10, ByteOrder byteOrder) {
            return k(new int[]{i10}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i10 : iArr) {
                wrap.putShort((short) i10);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public double l(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (o10 instanceof String) {
                return Double.parseDouble((String) o10);
            } else {
                if (o10 instanceof long[]) {
                    long[] jArr = (long[]) o10;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o10 instanceof int[]) {
                    int[] iArr = (int[]) o10;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o10 instanceof double[]) {
                    double[] dArr = (double[]) o10;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o10 instanceof f[]) {
                    f[] fVarArr = (f[]) o10;
                    if (fVarArr.length == 1) {
                        return fVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int m(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (o10 instanceof String) {
                return Integer.parseInt((String) o10);
            } else {
                if (o10 instanceof long[]) {
                    long[] jArr = (long[]) o10;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o10 instanceof int[]) {
                    int[] iArr = (int[]) o10;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String n(ByteOrder byteOrder) {
            Object o10 = o(byteOrder);
            if (o10 == null) {
                return null;
            }
            if (o10 instanceof String) {
                return (String) o10;
            }
            StringBuilder sb2 = new StringBuilder();
            int i10 = 0;
            if (o10 instanceof long[]) {
                long[] jArr = (long[]) o10;
                while (i10 < jArr.length) {
                    sb2.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (o10 instanceof int[]) {
                int[] iArr = (int[]) o10;
                while (i10 < iArr.length) {
                    sb2.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (o10 instanceof double[]) {
                double[] dArr = (double[]) o10;
                while (i10 < dArr.length) {
                    sb2.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (!(o10 instanceof f[])) {
                return null;
            } else {
                f[] fVarArr = (f[]) o10;
                while (i10 < fVarArr.length) {
                    sb2.append(fVarArr[i10].f15518a);
                    sb2.append('/');
                    sb2.append(fVarArr[i10].f15519b);
                    i10++;
                    if (i10 != fVarArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:162:0x018f A[SYNTHETIC, Splitter:B:162:0x018f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object o(java.nio.ByteOrder r12) {
            /*
                r11 = this;
                r0 = 0
                r1 = 1
                java.lang.String r2 = "IOException occurred while closing InputStream"
                java.lang.String r3 = "ExifInterface"
                r4 = 0
                androidx.exifinterface.media.ExifInterface$b r5 = new androidx.exifinterface.media.ExifInterface$b     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                byte[] r6 = r11.f15513d     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                r5.<init>((byte[]) r6)     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
                r5.h(r12)     // Catch:{ IOException -> 0x0033 }
                int r12 = r11.f15510a     // Catch:{ IOException -> 0x0033 }
                switch(r12) {
                    case 1: goto L_0x0149;
                    case 2: goto L_0x0103;
                    case 3: goto L_0x00ea;
                    case 4: goto L_0x00d1;
                    case 5: goto L_0x00af;
                    case 6: goto L_0x0149;
                    case 7: goto L_0x0103;
                    case 8: goto L_0x0096;
                    case 9: goto L_0x007d;
                    case 10: goto L_0x0059;
                    case 11: goto L_0x003f;
                    case 12: goto L_0x001f;
                    default: goto L_0x0016;
                }
            L_0x0016:
                r5.close()     // Catch:{ IOException -> 0x001a }
                goto L_0x001e
            L_0x001a:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x001e:
                return r4
            L_0x001f:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                double[] r12 = new double[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0023:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0036
                double r6 = r5.readDouble()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0023
            L_0x002f:
                r12 = move-exception
                r4 = r5
                goto L_0x018d
            L_0x0033:
                r12 = move-exception
                goto L_0x017d
            L_0x0036:
                r5.close()     // Catch:{ IOException -> 0x003a }
                goto L_0x003e
            L_0x003a:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x003e:
                return r12
            L_0x003f:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                double[] r12 = new double[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0043:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0050
                float r6 = r5.readFloat()     // Catch:{ IOException -> 0x0033 }
                double r6 = (double) r6     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0043
            L_0x0050:
                r5.close()     // Catch:{ IOException -> 0x0054 }
                goto L_0x0058
            L_0x0054:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0058:
                return r12
            L_0x0059:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$f[] r12 = new androidx.exifinterface.media.ExifInterface.f[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x005d:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x0074
                int r6 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                long r6 = (long) r6     // Catch:{ IOException -> 0x0033 }
                int r8 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                long r8 = (long) r8     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$f r10 = new androidx.exifinterface.media.ExifInterface$f     // Catch:{ IOException -> 0x0033 }
                r10.<init>(r6, r8)     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r10     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x005d
            L_0x0074:
                r5.close()     // Catch:{ IOException -> 0x0078 }
                goto L_0x007c
            L_0x0078:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x007c:
                return r12
            L_0x007d:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x0081:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x008d
                int r6 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x0081
            L_0x008d:
                r5.close()     // Catch:{ IOException -> 0x0091 }
                goto L_0x0095
            L_0x0091:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0095:
                return r12
            L_0x0096:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x009a:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00a6
                short r6 = r5.readShort()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x009a
            L_0x00a6:
                r5.close()     // Catch:{ IOException -> 0x00aa }
                goto L_0x00ae
            L_0x00aa:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x00ae:
                return r12
            L_0x00af:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$f[] r12 = new androidx.exifinterface.media.ExifInterface.f[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00b3:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00c8
                long r6 = r5.b()     // Catch:{ IOException -> 0x0033 }
                long r8 = r5.b()     // Catch:{ IOException -> 0x0033 }
                androidx.exifinterface.media.ExifInterface$f r10 = new androidx.exifinterface.media.ExifInterface$f     // Catch:{ IOException -> 0x0033 }
                r10.<init>(r6, r8)     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r10     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00b3
            L_0x00c8:
                r5.close()     // Catch:{ IOException -> 0x00cc }
                goto L_0x00d0
            L_0x00cc:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x00d0:
                return r12
            L_0x00d1:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                long[] r12 = new long[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00d5:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00e1
                long r6 = r5.b()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00d5
            L_0x00e1:
                r5.close()     // Catch:{ IOException -> 0x00e5 }
                goto L_0x00e9
            L_0x00e5:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x00e9:
                return r12
            L_0x00ea:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
            L_0x00ee:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x00fa
                int r6 = r5.readUnsignedShort()     // Catch:{ IOException -> 0x0033 }
                r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
                int r0 = r0 + r1
                goto L_0x00ee
            L_0x00fa:
                r5.close()     // Catch:{ IOException -> 0x00fe }
                goto L_0x0102
            L_0x00fe:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0102:
                return r12
            L_0x0103:
                int r12 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                byte[] r6 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0033 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0033 }
                if (r12 < r6) goto L_0x011c
                r12 = r0
            L_0x010b:
                byte[] r6 = androidx.exifinterface.media.ExifInterface.EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0033 }
                int r7 = r6.length     // Catch:{ IOException -> 0x0033 }
                if (r12 >= r7) goto L_0x011b
                byte[] r7 = r11.f15513d     // Catch:{ IOException -> 0x0033 }
                byte r7 = r7[r12]     // Catch:{ IOException -> 0x0033 }
                byte r6 = r6[r12]     // Catch:{ IOException -> 0x0033 }
                if (r7 == r6) goto L_0x0119
                goto L_0x011c
            L_0x0119:
                int r12 = r12 + r1
                goto L_0x010b
            L_0x011b:
                int r0 = r6.length     // Catch:{ IOException -> 0x0033 }
            L_0x011c:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0033 }
                r12.<init>()     // Catch:{ IOException -> 0x0033 }
            L_0x0121:
                int r6 = r11.f15511b     // Catch:{ IOException -> 0x0033 }
                if (r0 >= r6) goto L_0x013c
                byte[] r6 = r11.f15513d     // Catch:{ IOException -> 0x0033 }
                byte r6 = r6[r0]     // Catch:{ IOException -> 0x0033 }
                if (r6 != 0) goto L_0x012c
                goto L_0x013c
            L_0x012c:
                r7 = 32
                if (r6 < r7) goto L_0x0135
                char r6 = (char) r6     // Catch:{ IOException -> 0x0033 }
                r12.append(r6)     // Catch:{ IOException -> 0x0033 }
                goto L_0x013a
            L_0x0135:
                r6 = 63
                r12.append(r6)     // Catch:{ IOException -> 0x0033 }
            L_0x013a:
                int r0 = r0 + r1
                goto L_0x0121
            L_0x013c:
                java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0144 }
                goto L_0x0148
            L_0x0144:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0148:
                return r12
            L_0x0149:
                byte[] r12 = r11.f15513d     // Catch:{ IOException -> 0x0033 }
                int r6 = r12.length     // Catch:{ IOException -> 0x0033 }
                if (r6 != r1) goto L_0x0169
                byte r6 = r12[r0]     // Catch:{ IOException -> 0x0033 }
                if (r6 < 0) goto L_0x0169
                if (r6 > r1) goto L_0x0169
                java.lang.String r12 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
                int r6 = r6 + 48
                char r6 = (char) r6     // Catch:{ IOException -> 0x0033 }
                char[] r1 = new char[r1]     // Catch:{ IOException -> 0x0033 }
                r1[r0] = r6     // Catch:{ IOException -> 0x0033 }
                r12.<init>(r1)     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0164 }
                goto L_0x0168
            L_0x0164:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0168:
                return r12
            L_0x0169:
                java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
                java.nio.charset.Charset r1 = androidx.exifinterface.media.ExifInterface.ASCII     // Catch:{ IOException -> 0x0033 }
                r0.<init>(r12, r1)     // Catch:{ IOException -> 0x0033 }
                r5.close()     // Catch:{ IOException -> 0x0174 }
                goto L_0x0178
            L_0x0174:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x0178:
                return r0
            L_0x0179:
                r12 = move-exception
                goto L_0x018d
            L_0x017b:
                r12 = move-exception
                r5 = r4
            L_0x017d:
                java.lang.String r0 = "IOException occurred during reading a value"
                android.util.Log.w(r3, r0, r12)     // Catch:{ all -> 0x002f }
                if (r5 == 0) goto L_0x018c
                r5.close()     // Catch:{ IOException -> 0x0188 }
                goto L_0x018c
            L_0x0188:
                r12 = move-exception
                android.util.Log.e(r3, r2, r12)
            L_0x018c:
                return r4
            L_0x018d:
                if (r4 == 0) goto L_0x0197
                r4.close()     // Catch:{ IOException -> 0x0193 }
                goto L_0x0197
            L_0x0193:
                r0 = move-exception
                android.util.Log.e(r3, r2, r0)
            L_0x0197:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.f15510a] * this.f15511b;
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.f15510a] + ", data length:" + this.f15513d.length + ")";
        }

        d(int i10, int i11, long j10, byte[] bArr) {
            this.f15510a = i10;
            this.f15511b = i11;
            this.f15512c = j10;
            this.f15513d = bArr;
        }
    }

    private static class f {

        /* renamed from: a  reason: collision with root package name */
        public final long f15518a;

        /* renamed from: b  reason: collision with root package name */
        public final long f15519b;

        f(double d10) {
            this((long) (d10 * 10000.0d), WorkRequest.MIN_BACKOFF_MILLIS);
        }

        public double a() {
            return ((double) this.f15518a) / ((double) this.f15519b);
        }

        public String toString() {
            return this.f15518a + DomExceptionUtils.SEPARATOR + this.f15519b;
        }

        f(long j10, long j11) {
            if (j11 == 0) {
                this.f15518a = 0;
                this.f15519b = 1;
                return;
            }
            this.f15518a = j10;
            this.f15519b = j11;
        }
    }

    static {
        e eVar = new e(TAG_NEW_SUBFILE_TYPE, 254, 4);
        e eVar2 = new e(TAG_SUBFILE_TYPE, 255, 4);
        e eVar3 = new e(TAG_IMAGE_WIDTH, 256, 3, 4);
        e eVar4 = new e(TAG_IMAGE_LENGTH, InputDeviceCompat.SOURCE_KEYBOARD, 3, 4);
        e eVar5 = new e(TAG_BITS_PER_SAMPLE, 258, 3);
        e eVar6 = new e(TAG_COMPRESSION, 259, 3);
        e eVar7 = new e(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3);
        e eVar8 = new e(TAG_IMAGE_DESCRIPTION, 270, 2);
        e eVar9 = new e(TAG_MAKE, 271, 2);
        e eVar10 = new e(TAG_MODEL, 272, 2);
        e eVar11 = new e(TAG_STRIP_OFFSETS, 273, 3, 4);
        e eVar12 = new e(TAG_ORIENTATION, 274, 3);
        String str = TAG_STRIP_OFFSETS;
        e eVar13 = new e(TAG_SAMPLES_PER_PIXEL, 277, 3);
        e eVar14 = eVar12;
        e eVar15 = new e(TAG_ROWS_PER_STRIP, 278, 3, 4);
        e eVar16 = new e(TAG_STRIP_BYTE_COUNTS, 279, 3, 4);
        e eVar17 = new e(TAG_X_RESOLUTION, 282, 5);
        e eVar18 = new e(TAG_Y_RESOLUTION, 283, 5);
        e eVar19 = new e(TAG_PLANAR_CONFIGURATION, 284, 3);
        e eVar20 = new e(TAG_RESOLUTION_UNIT, 296, 3);
        e eVar21 = new e(TAG_TRANSFER_FUNCTION, PlatformUtils.LOCATION_CODE, 3);
        e eVar22 = new e(TAG_SOFTWARE, 305, 2);
        e eVar23 = new e(TAG_DATETIME, 306, 2);
        e eVar24 = new e(TAG_ARTIST, 315, 2);
        e eVar25 = new e(TAG_WHITE_POINT, 318, 5);
        e eVar26 = new e(TAG_PRIMARY_CHROMATICITIES, 319, 5);
        e eVar27 = new e(TAG_SUB_IFD_POINTER, 330, 4);
        String str2 = TAG_SUB_IFD_POINTER;
        e eVar28 = eVar27;
        e eVar29 = new e(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4);
        e eVar30 = new e(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        e eVar31 = new e(TAG_Y_CB_CR_COEFFICIENTS, 529, 5);
        e eVar32 = new e(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3);
        e eVar33 = new e(TAG_Y_CB_CR_POSITIONING, 531, 3);
        e eVar34 = new e(TAG_REFERENCE_BLACK_WHITE, 532, 5);
        e eVar35 = new e(TAG_COPYRIGHT, 33432, 2);
        e eVar36 = new e(TAG_EXIF_IFD_POINTER, 34665, 4);
        String str3 = TAG_EXIF_IFD_POINTER;
        e[] eVarArr = {eVar, eVar2, eVar3, eVar4, eVar5, eVar6, eVar7, eVar8, eVar9, eVar10, eVar11, eVar14, eVar13, eVar15, eVar16, eVar17, eVar18, eVar19, eVar20, eVar21, eVar22, eVar23, eVar24, eVar25, eVar26, eVar28, eVar29, eVar30, eVar31, eVar32, eVar33, eVar34, eVar35, eVar36, new e(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new e(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new e(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new e(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new e(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new e(TAG_RW2_ISO, 23, 3), new e(TAG_RW2_JPG_FROM_RAW, 46, 7), new e(TAG_XMP, 700, 1)};
        IFD_TIFF_TAGS = eVarArr;
        e[] eVarArr2 = eVarArr;
        e[] eVarArr3 = {new e(TAG_EXPOSURE_TIME, 33434, 5), new e(TAG_F_NUMBER, 33437, 5), new e(TAG_EXPOSURE_PROGRAM, 34850, 3), new e(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new e(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new e(TAG_OECF, 34856, 7), new e(TAG_SENSITIVITY_TYPE, 34864, 3), new e(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new e(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new e(TAG_ISO_SPEED, 34867, 4), new e(TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new e(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new e(TAG_EXIF_VERSION, 36864, 2), new e(TAG_DATETIME_ORIGINAL, 36867, 2), new e(TAG_DATETIME_DIGITIZED, 36868, 2), new e(TAG_OFFSET_TIME, 36880, 2), new e(TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new e(TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new e(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new e(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new e(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new e(TAG_APERTURE_VALUE, 37378, 5), new e(TAG_BRIGHTNESS_VALUE, 37379, 10), new e(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new e(TAG_MAX_APERTURE_VALUE, 37381, 5), new e(TAG_SUBJECT_DISTANCE, 37382, 5), new e(TAG_METERING_MODE, 37383, 3), new e(TAG_LIGHT_SOURCE, 37384, 3), new e(TAG_FLASH, 37385, 3), new e(TAG_FOCAL_LENGTH, 37386, 5), new e(TAG_SUBJECT_AREA, 37396, 3), new e(TAG_MAKER_NOTE, 37500, 7), new e(TAG_USER_COMMENT, 37510, 7), new e(TAG_SUBSEC_TIME, 37520, 2), new e(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new e(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new e(TAG_FLASHPIX_VERSION, 40960, 7), new e(TAG_COLOR_SPACE, 40961, 3), new e(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new e(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new e(TAG_RELATED_SOUND_FILE, 40964, 2), new e(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new e(TAG_FLASH_ENERGY, 41483, 5), new e(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new e(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new e(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new e(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new e(TAG_SUBJECT_LOCATION, 41492, 3), new e(TAG_EXPOSURE_INDEX, 41493, 5), new e(TAG_SENSING_METHOD, 41495, 3), new e(TAG_FILE_SOURCE, 41728, 7), new e(TAG_SCENE_TYPE, 41729, 7), new e(TAG_CFA_PATTERN, 41730, 7), new e(TAG_CUSTOM_RENDERED, 41985, 3), new e(TAG_EXPOSURE_MODE, 41986, 3), new e(TAG_WHITE_BALANCE, 41987, 3), new e(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new e(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new e(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new e(TAG_GAIN_CONTROL, 41991, 3), new e(TAG_CONTRAST, 41992, 3), new e(TAG_SATURATION, 41993, 3), new e(TAG_SHARPNESS, 41994, 3), new e(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new e(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new e(TAG_IMAGE_UNIQUE_ID, 42016, 2), new e("CameraOwnerName", 42032, 2), new e(TAG_BODY_SERIAL_NUMBER, 42033, 2), new e(TAG_LENS_SPECIFICATION, 42034, 5), new e(TAG_LENS_MAKE, 42035, 2), new e(TAG_LENS_MODEL, 42036, 2), new e(TAG_GAMMA, 42240, 5), new e(TAG_DNG_VERSION, 50706, 1), new e(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_EXIF_TAGS = eVarArr3;
        e[] eVarArr4 = eVarArr3;
        e[] eVarArr5 = {new e(TAG_GPS_VERSION_ID, 0, 1), new e(TAG_GPS_LATITUDE_REF, 1, 2), new e(TAG_GPS_LATITUDE, 2, 5, 10), new e(TAG_GPS_LONGITUDE_REF, 3, 2), new e(TAG_GPS_LONGITUDE, 4, 5, 10), new e(TAG_GPS_ALTITUDE_REF, 5, 1), new e(TAG_GPS_ALTITUDE, 6, 5), new e(TAG_GPS_TIMESTAMP, 7, 5), new e(TAG_GPS_SATELLITES, 8, 2), new e(TAG_GPS_STATUS, 9, 2), new e(TAG_GPS_MEASURE_MODE, 10, 2), new e(TAG_GPS_DOP, 11, 5), new e(TAG_GPS_SPEED_REF, 12, 2), new e(TAG_GPS_SPEED, 13, 5), new e(TAG_GPS_TRACK_REF, 14, 2), new e(TAG_GPS_TRACK, 15, 5), new e(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new e(TAG_GPS_IMG_DIRECTION, 17, 5), new e(TAG_GPS_MAP_DATUM, 18, 2), new e(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new e(TAG_GPS_DEST_LATITUDE, 20, 5), new e(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new e(TAG_GPS_DEST_LONGITUDE, 22, 5), new e(TAG_GPS_DEST_BEARING_REF, 23, 2), new e(TAG_GPS_DEST_BEARING, 24, 5), new e(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new e(TAG_GPS_DEST_DISTANCE, 26, 5), new e(TAG_GPS_PROCESSING_METHOD, 27, 7), new e(TAG_GPS_AREA_INFORMATION, 28, 7), new e(TAG_GPS_DATESTAMP, 29, 2), new e(TAG_GPS_DIFFERENTIAL, 30, 3), new e(TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        IFD_GPS_TAGS = eVarArr5;
        e[] eVarArr6 = {new e(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = eVarArr6;
        String str4 = str;
        e[] eVarArr7 = eVarArr6;
        String str5 = str4;
        String str6 = str2;
        String str7 = str3;
        e[] eVarArr8 = {new e(TAG_NEW_SUBFILE_TYPE, 254, 4), new e(TAG_SUBFILE_TYPE, 255, 4), new e(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new e(TAG_THUMBNAIL_IMAGE_LENGTH, InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new e(TAG_BITS_PER_SAMPLE, 258, 3), new e(TAG_COMPRESSION, 259, 3), new e(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new e(TAG_IMAGE_DESCRIPTION, 270, 2), new e(TAG_MAKE, 271, 2), new e(TAG_MODEL, 272, 2), new e(str4, 273, 3, 4), new e(TAG_THUMBNAIL_ORIENTATION, 274, 3), new e(TAG_SAMPLES_PER_PIXEL, 277, 3), new e(TAG_ROWS_PER_STRIP, 278, 3, 4), new e(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new e(TAG_X_RESOLUTION, 282, 5), new e(TAG_Y_RESOLUTION, 283, 5), new e(TAG_PLANAR_CONFIGURATION, 284, 3), new e(TAG_RESOLUTION_UNIT, 296, 3), new e(TAG_TRANSFER_FUNCTION, PlatformUtils.LOCATION_CODE, 3), new e(TAG_SOFTWARE, 305, 2), new e(TAG_DATETIME, 306, 2), new e(TAG_ARTIST, 315, 2), new e(TAG_WHITE_POINT, 318, 5), new e(TAG_PRIMARY_CHROMATICITIES, 319, 5), new e(str6, 330, 4), new e(TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new e(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new e(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new e(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new e(TAG_Y_CB_CR_POSITIONING, 531, 3), new e(TAG_REFERENCE_BLACK_WHITE, 532, 5), new e(TAG_XMP, 700, 1), new e(TAG_COPYRIGHT, 33432, 2), new e(str7, 34665, 4), new e(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new e(TAG_DNG_VERSION, 50706, 1), new e(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = eVarArr8;
        TAG_RAF_IMAGE_SIZE = new e(str5, 273, 3);
        e[] eVarArr9 = {new e(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new e(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 4), new e(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 4)};
        ORF_MAKER_NOTE_TAGS = eVarArr9;
        e[] eVarArr10 = {new e(TAG_ORF_PREVIEW_IMAGE_START, InputDeviceCompat.SOURCE_KEYBOARD, 4), new e(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = eVarArr10;
        e[] eVarArr11 = {new e(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = eVarArr11;
        e[] eVarArr12 = {new e(TAG_COLOR_SPACE, 55, 3)};
        PEF_TAGS = eVarArr12;
        e[][] eVarArr13 = {eVarArr2, eVarArr4, eVarArr5, eVarArr7, eVarArr8, eVarArr2, eVarArr9, eVarArr10, eVarArr11, eVarArr12};
        EXIF_TAGS = eVarArr13;
        EXIF_POINTER_TAGS = new e[]{new e(str6, 330, 4), new e(str7, 34665, 4), new e(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new e(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new e(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, 1), new e(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, 1)};
        sExifTagMapsForReading = new HashMap[eVarArr13.length];
        sExifTagMapsForWriting = new HashMap[eVarArr13.length];
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        sFormatterPrimary = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(o.f18139c, locale);
        sFormatterSecondary = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            e[][] eVarArr14 = EXIF_TAGS;
            if (i10 < eVarArr14.length) {
                sExifTagMapsForReading[i10] = new HashMap<>();
                sExifTagMapsForWriting[i10] = new HashMap<>();
                for (e eVar37 : eVarArr14[i10]) {
                    sExifTagMapsForReading[i10].put(Integer.valueOf(eVar37.f15514a), eVar37);
                    sExifTagMapsForWriting[i10].put(eVar37.f15515b, eVar37);
                }
                i10++;
            } else {
                HashMap<Integer, Integer> hashMap = sExifPointerTagMap;
                e[] eVarArr15 = EXIF_POINTER_TAGS;
                hashMap.put(Integer.valueOf(eVarArr15[0].f15514a), 5);
                hashMap.put(Integer.valueOf(eVarArr15[1].f15514a), 1);
                hashMap.put(Integer.valueOf(eVarArr15[2].f15514a), 2);
                hashMap.put(Integer.valueOf(eVarArr15[3].f15514a), 3);
                hashMap.put(Integer.valueOf(eVarArr15[4].f15514a), 7);
                hashMap.put(Integer.valueOf(eVarArr15[5].f15514a), 8);
                return;
            }
        }
    }

    public ExifInterface(@NonNull File file) throws IOException {
        e[][] eVarArr = EXIF_TAGS;
        this.mAttributes = new HashMap[eVarArr.length];
        this.mAttributesOffsets = new HashSet(eVarArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (file != null) {
            initForFilename(file.getAbsolutePath());
            return;
        }
        throw new NullPointerException("file cannot be null");
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.mAttributes[0].put(TAG_DATETIME, d.e(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, d.f(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, d.f(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.mAttributes[0].put(TAG_ORIENTATION, d.f(0, this.mExifByteOrder));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.mAttributes[1].put(TAG_LIGHT_SOURCE, d.f(0, this.mExifByteOrder));
        }
    }

    private String convertDecimalDegree(double d10) {
        long j10 = (long) d10;
        double d11 = d10 - ((double) j10);
        long j11 = (long) (d11 * 60.0d);
        long round = Math.round((d11 - (((double) j11) / 60.0d)) * 3600.0d * 1.0E7d);
        return j10 + "/1," + j11 + "/1," + round + "/10000000";
    }

    private static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split(DomExceptionUtils.SEPARATOR, -1);
            String[] split3 = split[1].split(DomExceptionUtils.SEPARATOR, -1);
            String[] split4 = split[2].split(DomExceptionUtils.SEPARATOR, -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals("S")) {
                if (!str2.equals(LONGITUDE_WEST)) {
                    if (!str2.equals("N")) {
                        if (!str2.equals(LONGITUDE_EAST)) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private void copyChunksUpToGivenChunkType(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = ASCII;
                sb2.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb2.append(str);
                throw new IOException(sb2.toString());
            }
            copyWebPChunk(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void copyWebPChunk(b bVar, c cVar, byte[] bArr) throws IOException {
        int readInt = bVar.readInt();
        cVar.write(bArr);
        cVar.h(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        a.f(bVar, cVar, readInt);
    }

    @Nullable
    private d getExifAttribute(@NonNull String str) {
        if (str != null) {
            if (TAG_ISO_SPEED_RATINGS.equals(str)) {
                if (DEBUG) {
                    Log.d(TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = TAG_PHOTOGRAPHIC_SENSITIVITY;
            }
            for (int i10 = 0; i10 < EXIF_TAGS.length; i10++) {
                d dVar = this.mAttributes[i10].get(str);
                if (dVar != null) {
                    return dVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:55|56|57) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0143, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0146, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0046, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x013b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getHeifAttributes(androidx.exifinterface.media.ExifInterface.g r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0147
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            androidx.exifinterface.media.ExifInterface$a r2 = new androidx.exifinterface.media.ExifInterface$a     // Catch:{ RuntimeException -> 0x013b }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x013b }
            androidx.exifinterface.media.a.b.a(r1, r2)     // Catch:{ RuntimeException -> 0x013b }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x013b }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x013b }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013b }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013b }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x013b }
            if (r4 == 0) goto L_0x0049
            r0 = 29
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013b }
            r4 = 30
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013b }
            r5 = 31
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013b }
            goto L_0x0065
        L_0x0046:
            r13 = move-exception
            goto L_0x0143
        L_0x0049:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x013b }
            if (r0 == 0) goto L_0x0062
            r0 = 18
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013b }
            r4 = 19
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013b }
            r5 = 24
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013b }
            goto L_0x0065
        L_0x0062:
            r0 = 0
            r4 = r0
            r5 = r4
        L_0x0065:
            r6 = 0
            if (r0 == 0) goto L_0x007b
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r7 = r12.mAttributes     // Catch:{ RuntimeException -> 0x013b }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x013b }
            java.nio.ByteOrder r10 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x013b }
            androidx.exifinterface.media.ExifInterface$d r9 = androidx.exifinterface.media.ExifInterface.d.j(r9, r10)     // Catch:{ RuntimeException -> 0x013b }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013b }
        L_0x007b:
            if (r4 == 0) goto L_0x0090
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r7 = r12.mAttributes     // Catch:{ RuntimeException -> 0x013b }
            r7 = r7[r6]     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x013b }
            java.nio.ByteOrder r10 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x013b }
            androidx.exifinterface.media.ExifInterface$d r9 = androidx.exifinterface.media.ExifInterface.d.j(r9, r10)     // Catch:{ RuntimeException -> 0x013b }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013b }
        L_0x0090:
            r7 = 6
            if (r5 == 0) goto L_0x00ba
            int r8 = java.lang.Integer.parseInt(r5)     // Catch:{ RuntimeException -> 0x013b }
            r9 = 90
            if (r8 == r9) goto L_0x00aa
            r9 = 180(0xb4, float:2.52E-43)
            if (r8 == r9) goto L_0x00a8
            r9 = 270(0x10e, float:3.78E-43)
            if (r8 == r9) goto L_0x00a5
            r8 = 1
            goto L_0x00ab
        L_0x00a5:
            r8 = 8
            goto L_0x00ab
        L_0x00a8:
            r8 = 3
            goto L_0x00ab
        L_0x00aa:
            r8 = r7
        L_0x00ab:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r9 = r12.mAttributes     // Catch:{ RuntimeException -> 0x013b }
            r9 = r9[r6]     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.mExifByteOrder     // Catch:{ RuntimeException -> 0x013b }
            androidx.exifinterface.media.ExifInterface$d r8 = androidx.exifinterface.media.ExifInterface.d.j(r8, r11)     // Catch:{ RuntimeException -> 0x013b }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x013b }
        L_0x00ba:
            if (r2 == 0) goto L_0x010d
            if (r3 == 0) goto L_0x010d
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x013b }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x013b }
            if (r3 <= r7) goto L_0x0105
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x013b }
            r13.k(r8)     // Catch:{ RuntimeException -> 0x013b }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x013b }
            int r9 = r13.read(r8)     // Catch:{ RuntimeException -> 0x013b }
            if (r9 != r7) goto L_0x00fd
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = IDENTIFIER_EXIF_APP1     // Catch:{ RuntimeException -> 0x013b }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x013b }
            if (r7 == 0) goto L_0x00f5
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x013b }
            int r13 = r13.read(r7)     // Catch:{ RuntimeException -> 0x013b }
            if (r13 != r3) goto L_0x00ed
            r12.mOffsetToExifData = r2     // Catch:{ RuntimeException -> 0x013b }
            r12.readExifSegment(r7, r6)     // Catch:{ RuntimeException -> 0x013b }
            goto L_0x010d
        L_0x00ed:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "Can't read exif"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013b }
            throw r13     // Catch:{ RuntimeException -> 0x013b }
        L_0x00f5:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "Invalid identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013b }
            throw r13     // Catch:{ RuntimeException -> 0x013b }
        L_0x00fd:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "Can't read identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013b }
            throw r13     // Catch:{ RuntimeException -> 0x013b }
        L_0x0105:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "Invalid exif length"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013b }
            throw r13     // Catch:{ RuntimeException -> 0x013b }
        L_0x010d:
            boolean r13 = DEBUG     // Catch:{ RuntimeException -> 0x013b }
            if (r13 == 0) goto L_0x0137
            java.lang.String r13 = "ExifInterface"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x013b }
            r2.<init>()     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r3 = "Heif meta: "
            r2.append(r3)     // Catch:{ RuntimeException -> 0x013b }
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = "x"
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013b }
            r2.append(r4)     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = ", rotation "
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013b }
            r2.append(r5)     // Catch:{ RuntimeException -> 0x013b }
            java.lang.String r0 = r2.toString()     // Catch:{ RuntimeException -> 0x013b }
            android.util.Log.d(r13, r0)     // Catch:{ RuntimeException -> 0x013b }
        L_0x0137:
            r1.release()
            return
        L_0x013b:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r13.<init>(r0)     // Catch:{ all -> 0x0046 }
            throw r13     // Catch:{ all -> 0x0046 }
        L_0x0143:
            r1.release()
            throw r13
        L_0x0147:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getHeifAttributes(androidx.exifinterface.media.ExifInterface$g):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x017b A[LOOP:0: B:8:0x0037->B:60:0x017b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0182 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getJpegAttributes(androidx.exifinterface.media.ExifInterface.b r22, int r23, int r24) throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            boolean r3 = DEBUG
            java.lang.String r4 = "ExifInterface"
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getJpegAttributes starting with: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r4, r3)
        L_0x0020:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.h(r3)
            byte r3 = r22.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r3 != r6) goto L_0x01cf
            byte r7 = r22.readByte()
            r8 = -40
            if (r7 != r8) goto L_0x01b4
            r3 = 2
        L_0x0037:
            byte r5 = r22.readByte()
            if (r5 != r6) goto L_0x0197
            byte r5 = r22.readByte()
            boolean r7 = DEBUG
            if (r7 == 0) goto L_0x005f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Found JPEG segment indicator: "
            r8.append(r9)
            r9 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r4, r8)
        L_0x005f:
            r8 = -39
            if (r5 == r8) goto L_0x0191
            r8 = -38
            if (r5 != r8) goto L_0x0069
            goto L_0x0191
        L_0x0069:
            int r8 = r22.readUnsignedShort()
            int r9 = r8 + -2
            r10 = 4
            int r3 = r3 + r10
            if (r7 == 0) goto L_0x009a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "JPEG segment: "
            r7.append(r11)
            r11 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r7.append(r11)
            java.lang.String r11 = " (length: "
            r7.append(r11)
            r7.append(r8)
            java.lang.String r11 = ")"
            r7.append(r11)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r4, r7)
        L_0x009a:
            java.lang.String r7 = "Invalid length"
            if (r9 < 0) goto L_0x018a
            r11 = -31
            r12 = 1
            r13 = 0
            if (r5 == r11) goto L_0x011d
            r11 = -2
            if (r5 == r11) goto L_0x00ef
            switch(r5) {
                case -64: goto L_0x00b7;
                case -63: goto L_0x00b7;
                case -62: goto L_0x00b7;
                case -61: goto L_0x00b7;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            switch(r5) {
                case -59: goto L_0x00b7;
                case -58: goto L_0x00b7;
                case -57: goto L_0x00b7;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            switch(r5) {
                case -55: goto L_0x00b7;
                case -54: goto L_0x00b7;
                case -53: goto L_0x00b7;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            switch(r5) {
                case -51: goto L_0x00b7;
                case -50: goto L_0x00b7;
                case -49: goto L_0x00b7;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            r20 = r7
            goto L_0x0179
        L_0x00b7:
            r1.j(r12)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r5 = r0.mAttributes
            r5 = r5[r2]
            if (r2 == r10) goto L_0x00c3
            java.lang.String r9 = "ImageLength"
            goto L_0x00c5
        L_0x00c3:
            java.lang.String r9 = "ThumbnailImageLength"
        L_0x00c5:
            int r11 = r22.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r11 = androidx.exifinterface.media.ExifInterface.d.f(r11, r13)
            r5.put(r9, r11)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r5 = r0.mAttributes
            r5 = r5[r2]
            if (r2 == r10) goto L_0x00dc
            java.lang.String r9 = "ImageWidth"
            goto L_0x00de
        L_0x00dc:
            java.lang.String r9 = "ThumbnailImageWidth"
        L_0x00de:
            int r10 = r22.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r10 = androidx.exifinterface.media.ExifInterface.d.f(r10, r12)
            r5.put(r9, r10)
            int r9 = r8 + -7
            goto L_0x00b3
        L_0x00ef:
            byte[] r5 = new byte[r9]
            int r8 = r1.read(r5)
            if (r8 != r9) goto L_0x0115
            java.lang.String r8 = "UserComment"
            java.lang.String r9 = r0.getAttribute(r8)
            if (r9 != 0) goto L_0x0111
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r9 = r0.mAttributes
            r9 = r9[r12]
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = ASCII
            r10.<init>(r5, r11)
            androidx.exifinterface.media.ExifInterface$d r5 = androidx.exifinterface.media.ExifInterface.d.e(r10)
            r9.put(r8, r5)
        L_0x0111:
            r20 = r7
        L_0x0113:
            r9 = r13
            goto L_0x0179
        L_0x0115:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x011d:
            byte[] r5 = new byte[r9]
            r1.readFully(r5)
            int r8 = r3 + r9
            byte[] r10 = IDENTIFIER_EXIF_APP1
            boolean r11 = androidx.exifinterface.media.a.h(r5, r10)
            if (r11 == 0) goto L_0x0145
            int r11 = r10.length
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r11, r9)
            int r3 = r23 + r3
            int r9 = r10.length
            int r3 = r3 + r9
            r0.mOffsetToExifData = r3
            r0.readExifSegment(r5, r2)
            androidx.exifinterface.media.ExifInterface$b r3 = new androidx.exifinterface.media.ExifInterface$b
            r3.<init>((byte[]) r5)
            r0.setThumbnailData(r3)
        L_0x0142:
            r20 = r7
            goto L_0x0177
        L_0x0145:
            byte[] r10 = IDENTIFIER_XMP_APP1
            boolean r11 = androidx.exifinterface.media.a.h(r5, r10)
            if (r11 == 0) goto L_0x0142
            int r11 = r10.length
            int r3 = r3 + r11
            int r10 = r10.length
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r10, r9)
            java.lang.String r9 = "Xmp"
            java.lang.String r10 = r0.getAttribute(r9)
            if (r10 != 0) goto L_0x0142
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r10 = r0.mAttributes
            r10 = r10[r13]
            androidx.exifinterface.media.ExifInterface$d r11 = new androidx.exifinterface.media.ExifInterface$d
            int r15 = r5.length
            r20 = r7
            long r6 = (long) r3
            r3 = 1
            r14 = r11
            r16 = r15
            r15 = r3
            r17 = r6
            r19 = r5
            r14.<init>(r15, r16, r17, r19)
            r10.put(r9, r11)
            r0.mXmpIsFromSeparateMarker = r12
        L_0x0177:
            r3 = r8
            goto L_0x0113
        L_0x0179:
            if (r9 < 0) goto L_0x0182
            r1.j(r9)
            int r3 = r3 + r9
            r6 = -1
            goto L_0x0037
        L_0x0182:
            java.io.IOException r1 = new java.io.IOException
            r2 = r20
            r1.<init>(r2)
            throw r1
        L_0x018a:
            r2 = r7
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r2)
            throw r1
        L_0x0191:
            java.nio.ByteOrder r2 = r0.mExifByteOrder
            r1.h(r2)
            return
        L_0x0197:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r5 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01b4:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01cf:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getJpegAttributes(androidx.exifinterface.media.ExifInterface$b, int, int):void");
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(SIGNATURE_CHECK_SIZE);
        byte[] bArr = new byte[SIGNATURE_CHECK_SIZE];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isHeifFormat(bArr)) {
            return 12;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        if (isRw2Format(bArr)) {
            return 10;
        }
        if (isPngFormat(bArr)) {
            return 13;
        }
        if (isWebpFormat(bArr)) {
            return 14;
        }
        return 0;
    }

    private void getOrfAttributes(g gVar) throws IOException {
        int i10;
        int i11;
        getRawAttributes(gVar);
        d dVar = this.mAttributes[1].get(TAG_MAKER_NOTE);
        if (dVar != null) {
            g gVar2 = new g(dVar.f15513d);
            gVar2.h(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.k(0);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.k(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.k(12);
            }
            readImageFileDirectory(gVar2, 6);
            d dVar2 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            d dVar3 = this.mAttributes[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (!(dVar2 == null || dVar3 == null)) {
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT, dVar2);
                this.mAttributes[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, dVar3);
            }
            d dVar4 = this.mAttributes[8].get(TAG_ORF_ASPECT_FRAME);
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.o(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Log.w(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i12 = iArr[2];
                int i13 = iArr[0];
                if (i12 > i13 && (i10 = iArr[3]) > (i11 = iArr[1])) {
                    int i14 = (i12 - i13) + 1;
                    int i15 = (i10 - i11) + 1;
                    if (i14 < i15) {
                        int i16 = i14 + i15;
                        i15 = i16 - i15;
                        i14 = i16 - i15;
                    }
                    d j10 = d.j(i14, this.mExifByteOrder);
                    d j11 = d.j(i15, this.mExifByteOrder);
                    this.mAttributes[0].put(TAG_IMAGE_WIDTH, j10);
                    this.mAttributes[0].put(TAG_IMAGE_LENGTH, j11);
                }
            }
        }
    }

    private void getPngAttributes(b bVar) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getPngAttributes starting with: " + bVar);
        }
        bVar.h(ByteOrder.BIG_ENDIAN);
        byte[] bArr = PNG_SIGNATURE;
        bVar.j(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i10 = length + 8;
                    if (i10 == 16) {
                        if (!Arrays.equals(bArr2, PNG_CHUNK_TYPE_IHDR)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, PNG_CHUNK_TYPE_IEND)) {
                        if (Arrays.equals(bArr2, PNG_CHUNK_TYPE_EXIF)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.mOffsetToExifData = i10;
                                    readExifSegment(bArr3, 0);
                                    validateImages();
                                    setThumbnailData(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + a.a(bArr2));
                        }
                        int i11 = readInt + 4;
                        bVar.j(i11);
                        length = i10 + i11;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void getRafAttributes(b bVar) throws IOException {
        boolean z10 = DEBUG;
        if (z10) {
            Log.d(TAG, "getRafAttributes starting with: " + bVar);
        }
        bVar.j(RAF_OFFSET_TO_JPEG_IMAGE_OFFSET);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.j(i10 - bVar.a());
        bVar.read(bArr4);
        getJpegAttributes(new b(bArr4), i10, 5);
        bVar.j(i12 - bVar.a());
        bVar.h(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z10) {
            Log.d(TAG, "numberOfDirectoryEntry: " + readInt);
        }
        for (int i13 = 0; i13 < readInt; i13++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.f15514a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d j10 = d.j(readShort, this.mExifByteOrder);
                d j11 = d.j(readShort2, this.mExifByteOrder);
                this.mAttributes[0].put(TAG_IMAGE_LENGTH, j10);
                this.mAttributes[0].put(TAG_IMAGE_WIDTH, j11);
                if (DEBUG) {
                    Log.d(TAG, "Updated to length: " + readShort + ", width: " + readShort2);
                    return;
                }
                return;
            }
            bVar.j(readUnsignedShort2);
        }
    }

    private void getRawAttributes(g gVar) throws IOException {
        d dVar;
        parseTiffHeaders(gVar);
        readImageFileDirectory(gVar, 0);
        updateImageSizeValues(gVar, 0);
        updateImageSizeValues(gVar, 5);
        updateImageSizeValues(gVar, 4);
        validateImages();
        if (this.mMimeType == 8 && (dVar = this.mAttributes[1].get(TAG_MAKER_NOTE)) != null) {
            g gVar2 = new g(dVar.f15513d);
            gVar2.h(this.mExifByteOrder);
            gVar2.j(6);
            readImageFileDirectory(gVar2, 9);
            d dVar2 = this.mAttributes[9].get(TAG_COLOR_SPACE);
            if (dVar2 != null) {
                this.mAttributes[1].put(TAG_COLOR_SPACE, dVar2);
            }
        }
    }

    private void getRw2Attributes(g gVar) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getRw2Attributes starting with: " + gVar);
        }
        getRawAttributes(gVar);
        d dVar = this.mAttributes[0].get(TAG_RW2_JPG_FROM_RAW);
        if (dVar != null) {
            getJpegAttributes(new b(dVar.f15513d), (int) dVar.f15512c, 5);
        }
        d dVar2 = this.mAttributes[0].get(TAG_RW2_ISO);
        d dVar3 = this.mAttributes[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (dVar2 != null && dVar3 == null) {
            this.mAttributes[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, dVar2);
        }
    }

    private void getStandaloneAttributes(g gVar) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        gVar.j(bArr.length);
        byte[] bArr2 = new byte[gVar.available()];
        gVar.readFully(bArr2);
        this.mOffsetToExifData = bArr.length;
        readExifSegment(bArr2, 0);
    }

    private void getWebpAttributes(b bVar) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "getWebpAttributes starting with: " + bVar);
        }
        bVar.h(ByteOrder.LITTLE_ENDIAN);
        bVar.j(WEBP_SIGNATURE_1.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = WEBP_SIGNATURE_2;
        bVar.j(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i10 = length + 8;
                    if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.mOffsetToExifData = i10;
                            readExifSegment(bArr3, 0);
                            setThumbnailData(new b(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + a.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i10 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            bVar.j(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:67|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        java.lang.Double.parseDouble(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x014a, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0150, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x013c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r10) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r10.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r10 = r10.split(r0, r6)
            r0 = r10[r2]
            android.util.Pair r0 = guessDataFormat(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r10.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r10[r3]
            android.util.Pair r1 = guessDataFormat(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r6
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = r6
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r10.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r10 = r10.split(r0, r6)
            int r0 = r10.length
            if (r0 != r4) goto L_0x00ff
            r0 = r10[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r10 = r10[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r4 = 10
            if (r10 < 0) goto L_0x00f5
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r0 = 5
            if (r10 > 0) goto L_0x00eb
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r10.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
            return r10
        L_0x00eb:
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r10
        L_0x00f5:
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r10
        L_0x00ff:
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x013c }
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r3 = 4
            if (r2 < 0) goto L_0x0124
            r8 = 65535(0xffff, double:3.23786E-319)
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x0124
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x0124:
            if (r2 >= 0) goto L_0x0132
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x0132:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x013c }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
            return r0
        L_0x013c:
            java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x014b }
            android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014b }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014b }
            r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x014b }
            return r10
        L_0x014b:
            android.util.Pair r10 = new android.util.Pair
            r10.<init>(r5, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.guessDataFormat(java.lang.String):android.util.Pair");
    }

    private void handleThumbnailFromJfif(b bVar, HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        d dVar2 = (d) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (dVar != null && dVar2 != null) {
            int m10 = dVar.m(this.mExifByteOrder);
            int m11 = dVar2.m(this.mExifByteOrder);
            if (this.mMimeType == 7) {
                m10 += this.mOrfMakerNoteOffset;
            }
            if (m10 > 0 && m11 > 0) {
                this.mHasThumbnail = true;
                if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                    byte[] bArr = new byte[m11];
                    bVar.skip((long) m10);
                    bVar.read(bArr);
                    this.mThumbnailBytes = bArr;
                }
                this.mThumbnailOffset = m10;
                this.mThumbnailLength = m11;
            }
            if (DEBUG) {
                Log.d(TAG, "Setting thumbnail attributes with offset: " + m10 + ", length: " + m11);
            }
        }
    }

    private void handleThumbnailFromStrips(b bVar, HashMap hashMap) throws IOException {
        b bVar2 = bVar;
        HashMap hashMap2 = hashMap;
        d dVar = (d) hashMap2.get(TAG_STRIP_OFFSETS);
        d dVar2 = (d) hashMap2.get(TAG_STRIP_BYTE_COUNTS);
        if (dVar != null && dVar2 != null) {
            long[] d10 = a.d(dVar.o(this.mExifByteOrder));
            long[] d11 = a.d(dVar2.o(this.mExifByteOrder));
            if (d10 == null || d10.length == 0) {
                Log.w(TAG, "stripOffsets should not be null or have zero length.");
            } else if (d11 == null || d11.length == 0) {
                Log.w(TAG, "stripByteCounts should not be null or have zero length.");
            } else if (d10.length != d11.length) {
                Log.w(TAG, "stripOffsets and stripByteCounts should have same length.");
            } else {
                long j10 = 0;
                for (long j11 : d11) {
                    j10 += j11;
                }
                int i10 = (int) j10;
                byte[] bArr = new byte[i10];
                this.mAreThumbnailStripsConsecutive = true;
                this.mHasThumbnailStrips = true;
                this.mHasThumbnail = true;
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < d10.length; i13++) {
                    int i14 = (int) d10[i13];
                    int i15 = (int) d11[i13];
                    if (i13 < d10.length - 1 && ((long) (i14 + i15)) != d10[i13 + 1]) {
                        this.mAreThumbnailStripsConsecutive = false;
                    }
                    int i16 = i14 - i11;
                    if (i16 < 0) {
                        Log.d(TAG, "Invalid strip offset value");
                        return;
                    }
                    long j12 = (long) i16;
                    if (bVar2.skip(j12) != j12) {
                        Log.d(TAG, "Failed to skip " + i16 + " bytes.");
                        return;
                    }
                    int i17 = i11 + i16;
                    byte[] bArr2 = new byte[i15];
                    if (bVar2.read(bArr2) != i15) {
                        Log.d(TAG, "Failed to read " + i15 + " bytes.");
                        return;
                    }
                    i11 = i17 + i15;
                    System.arraycopy(bArr2, 0, bArr, i12, i15);
                    i12 += i15;
                }
                this.mThumbnailBytes = bArr;
                if (this.mAreThumbnailStripsConsecutive) {
                    this.mThumbnailOffset = (int) d10[0];
                    this.mThumbnailLength = i10;
                }
            }
        }
    }

    private void initForFilename(String str) throws IOException {
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    if (isSeekableFD(fileInputStream2.getFD())) {
                        this.mSeekableFileDescriptor = fileInputStream2.getFD();
                    } else {
                        this.mSeekableFileDescriptor = null;
                    }
                    loadAttributes(fileInputStream2);
                    a.c(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a.c(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                a.c(fileInputStream);
                throw th;
            }
        } else {
            throw new NullPointerException("filename cannot be null");
        }
    }

    private static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = IDENTIFIER_EXIF_APP1;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = IDENTIFIER_EXIF_APP1;
            if (i10 >= bArr3.length) {
                return true;
            }
            if (bArr2[i10] != bArr3[i10]) {
                return false;
            }
            i10++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0093 A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isHeifFormat(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$b r2 = new androidx.exifinterface.media.ExifInterface$b     // Catch:{ Exception -> 0x008e }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008e }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r2.read(r5)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            byte[] r6 = HEIF_TYPE_FTYP     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r8 = 8
            if (r7 != 0) goto L_0x003b
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r10 = 16
            int r7 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x003c
            r2.close()
            return r0
        L_0x0034:
            r15 = move-exception
            r1 = r2
            goto L_0x00a0
        L_0x0038:
            r15 = move-exception
            r1 = r2
            goto L_0x008f
        L_0x003b:
            r10 = r8
        L_0x003c:
            int r7 = r15.length     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r12 = (long) r7     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x0044
            int r15 = r15.length     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            long r3 = (long) r15
        L_0x0044:
            long r3 = r3 - r10
            int r15 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r15 >= 0) goto L_0x004d
            r2.close()
            return r0
        L_0x004d:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r7 = 0
            r9 = r0
            r10 = r9
        L_0x0053:
            r11 = 4
            long r11 = r3 / r11
            int r11 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0088
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r11 == r1) goto L_0x0065
            r2.close()
            return r0
        L_0x0065:
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 != 0) goto L_0x006a
            goto L_0x0086
        L_0x006a:
            byte[] r11 = HEIF_BRAND_MIF1     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r12 = 1
            if (r11 == 0) goto L_0x0075
            r9 = r12
            goto L_0x007e
        L_0x0075:
            byte[] r11 = HEIF_BRAND_HEIC     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r11 == 0) goto L_0x007e
            r10 = r12
        L_0x007e:
            if (r9 == 0) goto L_0x0086
            if (r10 == 0) goto L_0x0086
            r2.close()
            return r12
        L_0x0086:
            long r7 = r7 + r5
            goto L_0x0053
        L_0x0088:
            r2.close()
            goto L_0x009f
        L_0x008c:
            r15 = move-exception
            goto L_0x00a0
        L_0x008e:
            r15 = move-exception
        L_0x008f:
            boolean r2 = DEBUG     // Catch:{ all -> 0x008c }
            if (r2 == 0) goto L_0x009a
            java.lang.String r2 = "ExifInterface"
            java.lang.String r3 = "Exception parsing HEIF file type box."
            android.util.Log.d(r2, r3, r15)     // Catch:{ all -> 0x008c }
        L_0x009a:
            if (r1 == 0) goto L_0x009f
            r1.close()
        L_0x009f:
            return r0
        L_0x00a0:
            if (r1 == 0) goto L_0x00a5
            r1.close()
        L_0x00a5:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isHeifFormat(byte[]):boolean");
    }

    private static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isOrfFormat(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$b r2 = new androidx.exifinterface.media.ExifInterface$b     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.h(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isOrfFormat(byte[]):boolean");
    }

    private boolean isPngFormat(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = PNG_SIGNATURE;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = RAF_SIGNATURE.getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isRw2Format(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            androidx.exifinterface.media.ExifInterface$b r2 = new androidx.exifinterface.media.ExifInterface$b     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.readByteOrder(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.mExifByteOrder = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.h(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x0029
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r4
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.isRw2Format(byte[]):boolean");
    }

    private static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        try {
            a.C0200a.c(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!DEBUG) {
                return false;
            }
            Log.d(TAG, "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        d dVar;
        int m10;
        d dVar2 = (d) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.mExifByteOrder);
            int[] iArr2 = BITS_PER_SAMPLE_RGB;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.mMimeType == 3 && (dVar = (d) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((m10 = dVar.m(this.mExifByteOrder)) == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (m10 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "Unsupported data type value");
        return false;
    }

    private static boolean isSupportedFormatForSavingAttributes(int i10) {
        return i10 == 4 || i10 == 13 || i10 == 14 || i10 == 3 || i10 == 0;
    }

    public static boolean isSupportedMimeType(@NonNull String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            lowerCase.hashCode();
            char c10 = 65535;
            switch (lowerCase.hashCode()) {
                case -1875291391:
                    if (lowerCase.equals("image/x-fuji-raf")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1635437028:
                    if (lowerCase.equals("image/x-samsung-srw")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -1594371159:
                    if (lowerCase.equals("image/x-sony-arw")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case -1487464693:
                    if (lowerCase.equals(ClipboardModule.MIMETYPE_HEIC)) {
                        c10 = 3;
                        break;
                    }
                    break;
                case -1487464690:
                    if (lowerCase.equals(ClipboardModule.MIMETYPE_HEIF)) {
                        c10 = 4;
                        break;
                    }
                    break;
                case -1487394660:
                    if (lowerCase.equals(ClipboardModule.MIMETYPE_JPEG)) {
                        c10 = 5;
                        break;
                    }
                    break;
                case -1487018032:
                    if (lowerCase.equals(ClipboardModule.MIMETYPE_WEBP)) {
                        c10 = 6;
                        break;
                    }
                    break;
                case -1423313290:
                    if (lowerCase.equals("image/x-adobe-dng")) {
                        c10 = 7;
                        break;
                    }
                    break;
                case -985160897:
                    if (lowerCase.equals("image/x-panasonic-rw2")) {
                        c10 = 8;
                        break;
                    }
                    break;
                case -879258763:
                    if (lowerCase.equals(ClipboardModule.MIMETYPE_PNG)) {
                        c10 = 9;
                        break;
                    }
                    break;
                case -332763809:
                    if (lowerCase.equals("image/x-pentax-pef")) {
                        c10 = 10;
                        break;
                    }
                    break;
                case 1378106698:
                    if (lowerCase.equals("image/x-olympus-orf")) {
                        c10 = 11;
                        break;
                    }
                    break;
                case 2099152104:
                    if (lowerCase.equals("image/x-nikon-nef")) {
                        c10 = 12;
                        break;
                    }
                    break;
                case 2099152524:
                    if (lowerCase.equals("image/x-nikon-nrw")) {
                        c10 = 13;
                        break;
                    }
                    break;
                case 2111234748:
                    if (lowerCase.equals("image/x-canon-cr2")) {
                        c10 = 14;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                    return true;
                default:
                    return false;
            }
        } else {
            throw new NullPointerException("mimeType shouldn't be null");
        }
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get(TAG_IMAGE_LENGTH);
        d dVar2 = (d) hashMap.get(TAG_IMAGE_WIDTH);
        if (dVar == null || dVar2 == null) {
            return false;
        }
        int m10 = dVar.m(this.mExifByteOrder);
        int m11 = dVar2.m(this.mExifByteOrder);
        if (m10 > 512 || m11 > 512) {
            return false;
        }
        return true;
    }

    private boolean isWebpFormat(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = WEBP_SIGNATURE_1;
            if (i10 >= bArr2.length) {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = WEBP_SIGNATURE_2;
                    if (i11 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[WEBP_SIGNATURE_1.length + i11 + 4] != bArr3[i11]) {
                        return false;
                    }
                    i11++;
                }
            } else if (bArr[i10] != bArr2[i10]) {
                return false;
            } else {
                i10++;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x009f A[Catch:{ all -> 0x0015 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAttributes(@androidx.annotation.NonNull java.io.InputStream r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00b8
            r0 = 0
            r1 = r0
        L_0x0004:
            androidx.exifinterface.media.ExifInterface$e[][] r2 = EXIF_TAGS     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            int r2 = r2.length     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            if (r1 >= r2) goto L_0x001e
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r2 = r4.mAttributes     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r3.<init>()     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r2[r1] = r3     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0015:
            r5 = move-exception
            goto L_0x00ad
        L_0x0018:
            r5 = move-exception
            goto L_0x009b
        L_0x001b:
            r5 = move-exception
            goto L_0x009b
        L_0x001e:
            boolean r1 = r4.mIsExifDataOnly     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            if (r1 != 0) goto L_0x0030
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            int r5 = r4.getMimeType(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r4.mMimeType = r5     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r5 = r1
        L_0x0030:
            int r1 = r4.mMimeType     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            boolean r1 = shouldSupportSeek(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            if (r1 == 0) goto L_0x006b
            androidx.exifinterface.media.ExifInterface$g r0 = new androidx.exifinterface.media.ExifInterface$g     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r0.<init>((java.io.InputStream) r5)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            boolean r5 = r4.mIsExifDataOnly     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            if (r5 == 0) goto L_0x0045
            r4.getStandaloneAttributes(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0061
        L_0x0045:
            int r5 = r4.mMimeType     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r1 = 12
            if (r5 != r1) goto L_0x004f
            r4.getHeifAttributes(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0061
        L_0x004f:
            r1 = 7
            if (r5 != r1) goto L_0x0056
            r4.getOrfAttributes(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0061
        L_0x0056:
            r1 = 10
            if (r5 != r1) goto L_0x005e
            r4.getRw2Attributes(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0061
        L_0x005e:
            r4.getRawAttributes(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
        L_0x0061:
            int r5 = r4.mOffsetToExifData     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            long r1 = (long) r5     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r0.k(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r4.setThumbnailData(r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0090
        L_0x006b:
            androidx.exifinterface.media.ExifInterface$b r1 = new androidx.exifinterface.media.ExifInterface$b     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r1.<init>((java.io.InputStream) r5)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            int r5 = r4.mMimeType     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            r2 = 4
            if (r5 != r2) goto L_0x0079
            r4.getJpegAttributes(r1, r0, r0)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0090
        L_0x0079:
            r0 = 13
            if (r5 != r0) goto L_0x0081
            r4.getPngAttributes(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0090
        L_0x0081:
            r0 = 9
            if (r5 != r0) goto L_0x0089
            r4.getRafAttributes(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
            goto L_0x0090
        L_0x0089:
            r0 = 14
            if (r5 != r0) goto L_0x0090
            r4.getWebpAttributes(r1)     // Catch:{ IOException -> 0x001b, UnsupportedOperationException -> 0x0018 }
        L_0x0090:
            r4.addDefaultValuesForCompatibility()
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x00ac
        L_0x0097:
            r4.printAttributes()
            goto L_0x00ac
        L_0x009b:
            boolean r0 = DEBUG     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x00a6
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r5)     // Catch:{ all -> 0x0015 }
        L_0x00a6:
            r4.addDefaultValuesForCompatibility()
            if (r0 == 0) goto L_0x00ac
            goto L_0x0097
        L_0x00ac:
            return
        L_0x00ad:
            r4.addDefaultValuesForCompatibility()
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x00b7
            r4.printAttributes()
        L_0x00b7:
            throw r5
        L_0x00b8:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.loadAttributes(java.io.InputStream):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if ("-".equals(r1) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Long parseDateTime(@androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.lang.String r11, @androidx.annotation.Nullable java.lang.String r12) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x0084
            java.util.regex.Pattern r1 = NON_ZERO_TIME_PATTERN
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x0011
            goto L_0x0084
        L_0x0011:
            java.text.ParsePosition r1 = new java.text.ParsePosition
            r2 = 0
            r1.<init>(r2)
            java.text.SimpleDateFormat r3 = sFormatterPrimary     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r3 != 0) goto L_0x0028
            java.text.SimpleDateFormat r3 = sFormatterSecondary     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.util.Date r3 = r3.parse(r10, r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r3 != 0) goto L_0x0028
            return r0
        L_0x0028:
            long r3 = r3.getTime()     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0078
            r10 = 1
            java.lang.String r1 = r12.substring(r2, r10)     // Catch:{ IllegalArgumentException -> 0x0084 }
            r2 = 3
            java.lang.String r5 = r12.substring(r10, r2)     // Catch:{ IllegalArgumentException -> 0x0084 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ IllegalArgumentException -> 0x0084 }
            r6 = 6
            r7 = 4
            java.lang.String r6 = r12.substring(r7, r6)     // Catch:{ IllegalArgumentException -> 0x0084 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.lang.String r8 = "+"
            boolean r8 = r8.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            java.lang.String r9 = "-"
            if (r8 != 0) goto L_0x0056
            boolean r8 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r8 == 0) goto L_0x0078
        L_0x0056:
            java.lang.String r8 = ":"
            java.lang.String r12 = r12.substring(r2, r7)     // Catch:{ IllegalArgumentException -> 0x0084 }
            boolean r12 = r8.equals(r12)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0078
            r12 = 14
            if (r5 > r12) goto L_0x0078
            int r5 = r5 * 60
            int r5 = r5 + r6
            r12 = 60000(0xea60, float:8.4078E-41)
            int r5 = r5 * r12
            boolean r12 = r9.equals(r1)     // Catch:{ IllegalArgumentException -> 0x0084 }
            if (r12 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r10 = -1
        L_0x0075:
            int r5 = r5 * r10
            long r1 = (long) r5     // Catch:{ IllegalArgumentException -> 0x0084 }
            long r3 = r3 + r1
        L_0x0078:
            if (r11 == 0) goto L_0x007f
            long r10 = androidx.exifinterface.media.a.g(r11)     // Catch:{ IllegalArgumentException -> 0x0084 }
            long r3 = r3 + r10
        L_0x007f:
            java.lang.Long r10 = java.lang.Long.valueOf(r3)     // Catch:{ IllegalArgumentException -> 0x0084 }
            return r10
        L_0x0084:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.parseDateTime(java.lang.String, java.lang.String, java.lang.String):java.lang.Long");
    }

    private void parseTiffHeaders(b bVar) throws IOException {
        ByteOrder readByteOrder = readByteOrder(bVar);
        this.mExifByteOrder = readByteOrder;
        bVar.h(readByteOrder);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i10 = this.mMimeType;
        if (i10 == 7 || i10 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt >= 8) {
                int i11 = readInt - 8;
                if (i11 > 0) {
                    bVar.j(i11);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void printAttributes() {
        for (int i10 = 0; i10 < this.mAttributes.length; i10++) {
            Log.d(TAG, "The size of tag group[" + i10 + "]: " + this.mAttributes[i10].size());
            for (Map.Entry next : this.mAttributes[i10].entrySet()) {
                d dVar = (d) next.getValue();
                Log.d(TAG, "tagName: " + ((String) next.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.n(this.mExifByteOrder) + "'");
            }
        }
    }

    private ByteOrder readByteOrder(b bVar) throws IOException {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            if (DEBUG) {
                Log.d(TAG, "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (DEBUG) {
                Log.d(TAG, "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void readExifSegment(byte[] bArr, int i10) throws IOException {
        g gVar = new g(bArr);
        parseTiffHeaders(gVar);
        readImageFileDirectory(gVar, i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0285  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readImageFileDirectory(androidx.exifinterface.media.ExifInterface.g r29, int r30) throws java.io.IOException {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            r5 = 5
            r7 = 0
            java.util.Set<java.lang.Integer> r9 = r0.mAttributesOffsets
            int r10 = r1.f15506c
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.add(r10)
            short r9 = r29.readShort()
            boolean r10 = DEBUG
            java.lang.String r11 = "ExifInterface"
            if (r10 == 0) goto L_0x0031
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "numberOfDirectoryEntry: "
            r10.append(r12)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r11, r10)
        L_0x0031:
            if (r9 > 0) goto L_0x0034
            return
        L_0x0034:
            r10 = r7
        L_0x0035:
            if (r10 >= r9) goto L_0x0328
            int r14 = r29.readUnsignedShort()
            int r15 = r29.readUnsignedShort()
            int r12 = r29.readInt()
            int r13 = r29.a()
            long r3 = (long) r13
            r18 = 4
            long r3 = r3 + r18
            java.util.HashMap<java.lang.Integer, androidx.exifinterface.media.ExifInterface$e>[] r13 = sExifTagMapsForReading
            r13 = r13[r2]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            java.lang.Object r6 = r13.get(r6)
            androidx.exifinterface.media.ExifInterface$e r6 = (androidx.exifinterface.media.ExifInterface.e) r6
            boolean r13 = DEBUG
            if (r13 == 0) goto L_0x0092
            java.lang.Integer r20 = java.lang.Integer.valueOf(r30)
            java.lang.Integer r21 = java.lang.Integer.valueOf(r14)
            if (r6 == 0) goto L_0x006b
            java.lang.String r8 = r6.f15515b
            goto L_0x006c
        L_0x006b:
            r8 = 0
        L_0x006c:
            java.lang.Integer r22 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r23 = java.lang.Integer.valueOf(r12)
            r24 = r9
            java.lang.Object[] r9 = new java.lang.Object[r5]
            r9[r7] = r20
            r20 = 1
            r9[r20] = r21
            r20 = 2
            r9[r20] = r8
            r8 = 3
            r9[r8] = r22
            r8 = 4
            r9[r8] = r23
            java.lang.String r8 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r8 = java.lang.String.format(r8, r9)
            android.util.Log.d(r11, r8)
            goto L_0x0094
        L_0x0092:
            r24 = r9
        L_0x0094:
            r8 = 7
            if (r6 != 0) goto L_0x00b1
            if (r13 == 0) goto L_0x00ad
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r5 = "Skip the tag entry since tag number is not defined: "
            r9.append(r5)
            r9.append(r14)
            java.lang.String r5 = r9.toString()
            android.util.Log.d(r11, r5)
        L_0x00ad:
            r23 = r10
            goto L_0x012f
        L_0x00b1:
            if (r15 <= 0) goto L_0x00b8
            int[] r5 = IFD_FORMAT_BYTES_PER_FORMAT
            int r9 = r5.length
            if (r15 < r9) goto L_0x00bb
        L_0x00b8:
            r23 = r10
            goto L_0x0119
        L_0x00bb:
            boolean r9 = r6.a(r15)
            if (r9 != 0) goto L_0x00e6
            if (r13 == 0) goto L_0x00ad
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "Skip the tag entry since data format ("
            r5.append(r9)
            java.lang.String[] r9 = IFD_FORMAT_NAMES
            r9 = r9[r15]
            r5.append(r9)
            java.lang.String r9 = ") is unexpected for tag: "
            r5.append(r9)
            java.lang.String r9 = r6.f15515b
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r11, r5)
            goto L_0x00ad
        L_0x00e6:
            if (r15 != r8) goto L_0x00ea
            int r15 = r6.f15516c
        L_0x00ea:
            long r7 = (long) r12
            r5 = r5[r15]
            r23 = r10
            long r9 = (long) r5
            long r7 = r7 * r9
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x0101
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x00ff
            goto L_0x0101
        L_0x00ff:
            r5 = 1
            goto L_0x0132
        L_0x0101:
            if (r13 == 0) goto L_0x0117
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "Skip the tag entry since the number of components is invalid: "
            r5.append(r9)
            r5.append(r12)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r11, r5)
        L_0x0117:
            r5 = 0
            goto L_0x0132
        L_0x0119:
            if (r13 == 0) goto L_0x012f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Skip the tag entry since data format is invalid: "
            r5.append(r7)
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r11, r5)
        L_0x012f:
            r5 = 0
            r7 = 0
        L_0x0132:
            if (r5 != 0) goto L_0x013c
            r1.k(r3)
            r5 = r11
        L_0x0138:
            r3 = 3
        L_0x0139:
            r4 = 1
            goto L_0x031e
        L_0x013c:
            int r5 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            java.lang.String r10 = "Compression"
            if (r5 <= 0) goto L_0x01c3
            int r5 = r29.readInt()
            if (r13 == 0) goto L_0x015f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r25 = r3
            java.lang.String r3 = "seek to data offset: "
            r9.append(r3)
            r9.append(r5)
            java.lang.String r3 = r9.toString()
            android.util.Log.d(r11, r3)
            goto L_0x0161
        L_0x015f:
            r25 = r3
        L_0x0161:
            int r3 = r0.mMimeType
            r4 = 7
            if (r3 != r4) goto L_0x0172
            java.lang.String r3 = r6.f15515b
            java.lang.String r4 = "MakerNote"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0177
            r0.mOrfMakerNoteOffset = r5
        L_0x0172:
            r27 = r11
            r18 = r12
            goto L_0x01be
        L_0x0177:
            r3 = 6
            if (r2 != r3) goto L_0x0172
            java.lang.String r4 = "ThumbnailImage"
            java.lang.String r9 = r6.f15515b
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L_0x0172
            r0.mOrfThumbnailOffset = r5
            r0.mOrfThumbnailLength = r12
            java.nio.ByteOrder r4 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r3 = androidx.exifinterface.media.ExifInterface.d.j(r3, r4)
            int r4 = r0.mOrfThumbnailOffset
            r27 = r11
            r18 = r12
            long r11 = (long) r4
            java.nio.ByteOrder r4 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r4 = androidx.exifinterface.media.ExifInterface.d.f(r11, r4)
            int r9 = r0.mOrfThumbnailLength
            long r11 = (long) r9
            java.nio.ByteOrder r9 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r9 = androidx.exifinterface.media.ExifInterface.d.f(r11, r9)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r11 = r0.mAttributes
            r12 = 4
            r11 = r11[r12]
            r11.put(r10, r3)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r12]
            java.lang.String r11 = "JPEGInterchangeFormat"
            r3.put(r11, r4)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r12]
            java.lang.String r4 = "JPEGInterchangeFormatLength"
            r3.put(r4, r9)
        L_0x01be:
            long r3 = (long) r5
            r1.k(r3)
            goto L_0x01c9
        L_0x01c3:
            r25 = r3
            r27 = r11
            r18 = r12
        L_0x01c9:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r3 = sExifPointerTagMap
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            java.lang.Object r3 = r3.get(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r13 == 0) goto L_0x01f6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "nextIfdType: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r5 = " byteCount: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            r5 = r27
            android.util.Log.d(r5, r4)
            goto L_0x01f8
        L_0x01f6:
            r5 = r27
        L_0x01f8:
            r4 = 8
            if (r3 == 0) goto L_0x02a1
            r9 = 3
            if (r15 == r9) goto L_0x021f
            r7 = 4
            if (r15 == r7) goto L_0x021a
            if (r15 == r4) goto L_0x0215
            r4 = 9
            if (r15 == r4) goto L_0x020f
            r4 = 13
            if (r15 == r4) goto L_0x020f
            r7 = -1
            goto L_0x0224
        L_0x020f:
            int r4 = r29.readInt()
        L_0x0213:
            long r7 = (long) r4
            goto L_0x0224
        L_0x0215:
            short r4 = r29.readShort()
            goto L_0x0213
        L_0x021a:
            long r7 = r29.b()
            goto L_0x0224
        L_0x021f:
            int r4 = r29.readUnsignedShort()
            goto L_0x0213
        L_0x0224:
            if (r13 == 0) goto L_0x0241
            java.lang.Long r4 = java.lang.Long.valueOf(r7)
            java.lang.String r6 = r6.f15515b
            r11 = 2
            java.lang.Object[] r10 = new java.lang.Object[r11]
            r9 = 0
            r10[r9] = r4
            r4 = 1
            r10[r4] = r6
            java.lang.String r4 = "Offset: %d, tagName: %s"
            java.lang.String r4 = java.lang.String.format(r4, r10)
            android.util.Log.d(r5, r4)
        L_0x023e:
            r14 = 0
            goto L_0x0243
        L_0x0241:
            r11 = 2
            goto L_0x023e
        L_0x0243:
            int r4 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x0285
            java.util.Set<java.lang.Integer> r4 = r0.mAttributesOffsets
            int r6 = (int) r7
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r4 = r4.contains(r6)
            if (r4 != 0) goto L_0x0261
            r1.k(r7)
            int r3 = r3.intValue()
            r0.readImageFileDirectory(r1, r3)
        L_0x025e:
            r12 = r25
            goto L_0x029c
        L_0x0261:
            if (r13 == 0) goto L_0x025e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Skip jump into the IFD since it has already been read: IfdType "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = " (at "
            r4.append(r3)
            r4.append(r7)
            java.lang.String r3 = ")"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.d(r5, r3)
            goto L_0x025e
        L_0x0285:
            if (r13 == 0) goto L_0x025e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Skip jump into the IFD since its offset is invalid: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r5, r3)
            goto L_0x025e
        L_0x029c:
            r1.k(r12)
            goto L_0x0138
        L_0x02a1:
            r12 = r25
            r11 = 2
            int r3 = r29.a()
            int r14 = r0.mOffsetToExifData
            int r3 = r3 + r14
            int r7 = (int) r7
            byte[] r7 = new byte[r7]
            r1.readFully(r7)
            androidx.exifinterface.media.ExifInterface$d r8 = new androidx.exifinterface.media.ExifInterface$d
            long r11 = (long) r3
            r16 = r8
            r17 = r15
            r19 = r11
            r21 = r7
            r16.<init>(r17, r18, r19, r21)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r2]
            java.lang.String r7 = r6.f15515b
            r3.put(r7, r8)
            java.lang.String r3 = "DNGVersion"
            java.lang.String r7 = r6.f15515b
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x02d6
            r3 = 3
            r0.mMimeType = r3
            goto L_0x02d7
        L_0x02d6:
            r3 = 3
        L_0x02d7:
            java.lang.String r7 = "Make"
            java.lang.String r11 = r6.f15515b
            boolean r7 = r7.equals(r11)
            if (r7 != 0) goto L_0x02eb
            java.lang.String r7 = "Model"
            java.lang.String r11 = r6.f15515b
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x02f9
        L_0x02eb:
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            java.lang.String r7 = r8.n(r7)
            java.lang.String r11 = "PENTAX"
            boolean r7 = r7.contains(r11)
            if (r7 != 0) goto L_0x030c
        L_0x02f9:
            java.lang.String r6 = r6.f15515b
            boolean r6 = r10.equals(r6)
            if (r6 == 0) goto L_0x030e
            java.nio.ByteOrder r6 = r0.mExifByteOrder
            int r6 = r8.m(r6)
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r6 != r7) goto L_0x030e
        L_0x030c:
            r0.mMimeType = r4
        L_0x030e:
            int r4 = r29.a()
            long r6 = (long) r4
            int r4 = (r6 > r25 ? 1 : (r6 == r25 ? 0 : -1))
            if (r4 == 0) goto L_0x0139
            r6 = r25
            r1.k(r6)
            goto L_0x0139
        L_0x031e:
            int r10 = r23 + 1
            short r10 = (short) r10
            r11 = r5
            r9 = r24
            r5 = 5
            r7 = 0
            goto L_0x0035
        L_0x0328:
            r5 = r11
            r4 = 1
            int r2 = r29.readInt()
            boolean r3 = DEBUG
            if (r3 == 0) goto L_0x0344
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r7 = 0
            r4[r7] = r6
            java.lang.String r6 = "nextIfdOffset: %d"
            java.lang.String r4 = java.lang.String.format(r6, r4)
            android.util.Log.d(r5, r4)
        L_0x0344:
            long r6 = (long) r2
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x038f
            java.util.Set<java.lang.Integer> r4 = r0.mAttributesOffsets
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            boolean r4 = r4.contains(r8)
            if (r4 != 0) goto L_0x0378
            r1.k(r6)
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r2 = r0.mAttributes
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0369
            r0.readImageFileDirectory(r1, r3)
            goto L_0x03a5
        L_0x0369:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r2 = r0.mAttributes
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03a5
            r0.readImageFileDirectory(r1, r3)
            goto L_0x03a5
        L_0x0378:
            if (r3 == 0) goto L_0x03a5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r5, r1)
            goto L_0x03a5
        L_0x038f:
            if (r3 == 0) goto L_0x03a5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r5, r1)
        L_0x03a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.readImageFileDirectory(androidx.exifinterface.media.ExifInterface$g, int):void");
    }

    private void removeAttribute(String str) {
        for (int i10 = 0; i10 < EXIF_TAGS.length; i10++) {
            this.mAttributes[i10].remove(str);
        }
    }

    private void replaceInvalidTags(int i10, String str, String str2) {
        if (!this.mAttributes[i10].isEmpty() && this.mAttributes[i10].get(str) != null) {
            HashMap<String, d> hashMap = this.mAttributes[i10];
            hashMap.put(str2, hashMap.get(str));
            this.mAttributes[i10].remove(str);
        }
    }

    private void retrieveJpegImageSize(g gVar, int i10) throws IOException {
        d dVar = this.mAttributes[i10].get(TAG_IMAGE_LENGTH);
        d dVar2 = this.mAttributes[i10].get(TAG_IMAGE_WIDTH);
        if (dVar == null || dVar2 == null) {
            d dVar3 = this.mAttributes[i10].get(TAG_JPEG_INTERCHANGE_FORMAT);
            d dVar4 = this.mAttributes[i10].get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            if (dVar3 != null && dVar4 != null) {
                int m10 = dVar3.m(this.mExifByteOrder);
                int m11 = dVar3.m(this.mExifByteOrder);
                gVar.k((long) m10);
                byte[] bArr = new byte[m11];
                gVar.read(bArr);
                getJpegAttributes(new b(bArr), m10, i10);
            }
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        d dVar;
        if (DEBUG) {
            Log.d(TAG, "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() == -1) {
            cVar.b(-1);
            if (bVar.readByte() == -40) {
                cVar.b(-40);
                if (getAttribute(TAG_XMP) == null || !this.mXmpIsFromSeparateMarker) {
                    dVar = null;
                } else {
                    dVar = this.mAttributes[0].remove(TAG_XMP);
                }
                cVar.b(-1);
                cVar.b(-31);
                writeExifSegment(cVar);
                if (dVar != null) {
                    this.mAttributes[0].put(TAG_XMP, dVar);
                }
                byte[] bArr = new byte[4096];
                while (bVar.readByte() == -1) {
                    byte readByte = bVar.readByte();
                    if (readByte == -39 || readByte == -38) {
                        cVar.b(-1);
                        cVar.b(readByte);
                        a.e(bVar, cVar);
                        return;
                    } else if (readByte != -31) {
                        cVar.b(-1);
                        cVar.b(readByte);
                        int readUnsignedShort = bVar.readUnsignedShort();
                        cVar.m(readUnsignedShort);
                        int i10 = readUnsignedShort - 2;
                        if (i10 >= 0) {
                            while (i10 > 0) {
                                int read = bVar.read(bArr, 0, Math.min(i10, 4096));
                                if (read < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, read);
                                i10 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = bVar.readUnsignedShort();
                        int i11 = readUnsignedShort2 - 2;
                        if (i11 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (i11 >= 6) {
                                if (bVar.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                    bVar.j(readUnsignedShort2 - 8);
                                }
                            }
                            cVar.b(-1);
                            cVar.b(readByte);
                            cVar.m(readUnsignedShort2);
                            if (i11 >= 6) {
                                i11 = readUnsignedShort2 - 8;
                                cVar.write(bArr2);
                            }
                            while (i11 > 0) {
                                int read2 = bVar.read(bArr, 0, Math.min(i11, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, read2);
                                i11 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void savePngAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (DEBUG) {
            Log.d(TAG, "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = PNG_SIGNATURE;
        a.f(bVar, cVar, bArr.length);
        int i10 = this.mOffsetToExifData;
        if (i10 == 0) {
            int readInt = bVar.readInt();
            cVar.h(readInt);
            a.f(bVar, cVar, readInt + 8);
        } else {
            a.f(bVar, cVar, (i10 - bArr.length) - 8);
            bVar.j(bVar.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                writeExifSegment(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f15508a).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.h((int) crc32.getValue());
                a.c(byteArrayOutputStream2);
                a.e(bVar, cVar);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                a.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            a.c(byteArrayOutputStream);
            throw th;
        }
    }

    private void saveWebpAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        if (DEBUG) {
            Log.d(TAG, "saveWebpAttributes starting with (inputStream: " + inputStream2 + ", outputStream: " + outputStream2 + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream2, byteOrder);
        c cVar = new c(outputStream2, byteOrder);
        byte[] bArr = WEBP_SIGNATURE_1;
        a.f(bVar, cVar, bArr.length);
        byte[] bArr2 = WEBP_SIGNATURE_2;
        bVar.j(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                int i16 = this.mOffsetToExifData;
                if (i16 != 0) {
                    a.f(bVar, cVar2, (i16 - ((bArr.length + 4) + bArr2.length)) - 8);
                    bVar.j(4);
                    bVar.j(bVar.readInt());
                    writeExifSegment(cVar2);
                } else {
                    byte[] bArr3 = new byte[4];
                    if (bVar.read(bArr3) == 4) {
                        byte[] bArr4 = WEBP_CHUNK_TYPE_VP8X;
                        boolean z10 = false;
                        if (Arrays.equals(bArr3, bArr4)) {
                            int readInt = bVar.readInt();
                            if (readInt % 2 == 1) {
                                i15 = readInt + 1;
                            } else {
                                i15 = readInt;
                            }
                            byte[] bArr5 = new byte[i15];
                            bVar.read(bArr5);
                            byte b10 = (byte) (8 | bArr5[0]);
                            bArr5[0] = b10;
                            if (((b10 >> 1) & 1) == 1) {
                                z10 = true;
                            }
                            cVar2.write(bArr4);
                            cVar2.h(readInt);
                            cVar2.write(bArr5);
                            if (z10) {
                                copyChunksUpToGivenChunkType(bVar, cVar2, WEBP_CHUNK_TYPE_ANIM, (byte[]) null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream2.read(bArr6);
                                    if (!Arrays.equals(bArr6, WEBP_CHUNK_TYPE_ANMF)) {
                                        break;
                                    }
                                    copyWebPChunk(bVar, cVar2, bArr6);
                                }
                                writeExifSegment(cVar2);
                            } else {
                                copyChunksUpToGivenChunkType(bVar, cVar2, WEBP_CHUNK_TYPE_VP8, WEBP_CHUNK_TYPE_VP8L);
                                writeExifSegment(cVar2);
                            }
                        } else {
                            byte[] bArr7 = WEBP_CHUNK_TYPE_VP8;
                            if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                int readInt2 = bVar.readInt();
                                if (readInt2 % 2 == 1) {
                                    i10 = readInt2 + 1;
                                } else {
                                    i10 = readInt2;
                                }
                                byte[] bArr8 = new byte[3];
                                if (Arrays.equals(bArr3, bArr7)) {
                                    bVar.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    if (bVar.read(bArr9) != 3 || !Arrays.equals(WEBP_VP8_SIGNATURE, bArr9)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    i14 = bVar.readInt();
                                    i13 = (i14 << 18) >> 18;
                                    i12 = (i14 << 2) >> 18;
                                    i10 -= 10;
                                    i11 = 0;
                                } else if (!Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                    i14 = 0;
                                    i13 = 0;
                                    i12 = 0;
                                    i11 = 0;
                                } else if (bVar.readByte() == 47) {
                                    i14 = bVar.readInt();
                                    i11 = i14 & 8;
                                    i10 -= 5;
                                    i12 = ((i14 << 4) >> 18) + 1;
                                    i13 = ((i14 << 18) >> 18) + 1;
                                } else {
                                    throw new IOException("Encountered error while checking VP8L signature");
                                }
                                cVar2.write(bArr4);
                                cVar2.h(10);
                                byte[] bArr10 = new byte[10];
                                byte b11 = (byte) (bArr10[0] | 8);
                                bArr10[0] = b11;
                                bArr10[0] = (byte) (b11 | (i11 << 4));
                                int i17 = i13 - 1;
                                int i18 = i12 - 1;
                                bArr10[4] = (byte) i17;
                                bArr10[5] = (byte) (i17 >> 8);
                                bArr10[6] = (byte) (i17 >> 16);
                                bArr10[7] = (byte) i18;
                                bArr10[8] = (byte) (i18 >> 8);
                                bArr10[9] = (byte) (i18 >> 16);
                                cVar2.write(bArr10);
                                cVar2.write(bArr3);
                                cVar2.h(readInt2);
                                if (Arrays.equals(bArr3, bArr7)) {
                                    cVar2.write(bArr8);
                                    cVar2.write(WEBP_VP8_SIGNATURE);
                                    cVar2.h(i14);
                                } else if (Arrays.equals(bArr3, WEBP_CHUNK_TYPE_VP8L)) {
                                    cVar2.write(47);
                                    cVar2.h(i14);
                                }
                                a.f(bVar, cVar2, i10);
                                writeExifSegment(cVar2);
                            }
                        }
                    } else {
                        throw new IOException("Encountered invalid length while parsing WebP chunk type");
                    }
                }
                a.e(bVar, cVar2);
                int size = byteArrayOutputStream2.size();
                byte[] bArr11 = WEBP_SIGNATURE_2;
                cVar.h(size + bArr11.length);
                cVar.write(bArr11);
                byteArrayOutputStream2.writeTo(cVar);
                a.c(byteArrayOutputStream2);
            } catch (Exception e10) {
                e = e10;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    a.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                a.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            throw new IOException("Failed to save WebP file", e);
        }
    }

    private void setThumbnailData(b bVar) throws IOException {
        HashMap<String, d> hashMap = this.mAttributes[4];
        d dVar = hashMap.get(TAG_COMPRESSION);
        if (dVar != null) {
            int m10 = dVar.m(this.mExifByteOrder);
            this.mThumbnailCompression = m10;
            if (m10 != 1) {
                if (m10 == 6) {
                    handleThumbnailFromJfif(bVar, hashMap);
                    return;
                } else if (m10 != 7) {
                    return;
                }
            }
            if (isSupportedDataType(hashMap)) {
                handleThumbnailFromStrips(bVar, hashMap);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(bVar, hashMap);
    }

    private static boolean shouldSupportSeek(int i10) {
        return (i10 == 4 || i10 == 9 || i10 == 13 || i10 == 14) ? false : true;
    }

    private void swapBasedOnImageSize(int i10, int i11) throws IOException {
        if (!this.mAttributes[i10].isEmpty() && !this.mAttributes[i11].isEmpty()) {
            d dVar = this.mAttributes[i10].get(TAG_IMAGE_LENGTH);
            d dVar2 = this.mAttributes[i10].get(TAG_IMAGE_WIDTH);
            d dVar3 = this.mAttributes[i11].get(TAG_IMAGE_LENGTH);
            d dVar4 = this.mAttributes[i11].get(TAG_IMAGE_WIDTH);
            if (dVar == null || dVar2 == null) {
                if (DEBUG) {
                    Log.d(TAG, "First image does not contain valid size information");
                }
            } else if (dVar3 != null && dVar4 != null) {
                int m10 = dVar.m(this.mExifByteOrder);
                int m11 = dVar2.m(this.mExifByteOrder);
                int m12 = dVar3.m(this.mExifByteOrder);
                int m13 = dVar4.m(this.mExifByteOrder);
                if (m10 < m12 && m11 < m13) {
                    HashMap<String, d>[] hashMapArr = this.mAttributes;
                    HashMap<String, d> hashMap = hashMapArr[i10];
                    hashMapArr[i10] = hashMapArr[i11];
                    hashMapArr[i11] = hashMap;
                }
            } else if (DEBUG) {
                Log.d(TAG, "Second image does not contain valid size information");
            }
        } else if (DEBUG) {
            Log.d(TAG, "Cannot perform swap since only one image data exists");
        }
    }

    private void updateImageSizeValues(g gVar, int i10) throws IOException {
        d dVar;
        d dVar2;
        d dVar3 = this.mAttributes[i10].get(TAG_DEFAULT_CROP_SIZE);
        d dVar4 = this.mAttributes[i10].get(TAG_RW2_SENSOR_TOP_BORDER);
        d dVar5 = this.mAttributes[i10].get(TAG_RW2_SENSOR_LEFT_BORDER);
        d dVar6 = this.mAttributes[i10].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        d dVar7 = this.mAttributes[i10].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (dVar3 != null) {
            if (dVar3.f15510a == 5) {
                f[] fVarArr = (f[]) dVar3.o(this.mExifByteOrder);
                if (fVarArr == null || fVarArr.length != 2) {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                    return;
                }
                dVar2 = d.h(fVarArr[0], this.mExifByteOrder);
                dVar = d.h(fVarArr[1], this.mExifByteOrder);
            } else {
                int[] iArr = (int[]) dVar3.o(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                dVar2 = d.j(iArr[0], this.mExifByteOrder);
                dVar = d.j(iArr[1], this.mExifByteOrder);
            }
            this.mAttributes[i10].put(TAG_IMAGE_WIDTH, dVar2);
            this.mAttributes[i10].put(TAG_IMAGE_LENGTH, dVar);
        } else if (dVar4 == null || dVar5 == null || dVar6 == null || dVar7 == null) {
            retrieveJpegImageSize(gVar, i10);
        } else {
            int m10 = dVar4.m(this.mExifByteOrder);
            int m11 = dVar6.m(this.mExifByteOrder);
            int m12 = dVar7.m(this.mExifByteOrder);
            int m13 = dVar5.m(this.mExifByteOrder);
            if (m11 > m10 && m12 > m13) {
                d j10 = d.j(m11 - m10, this.mExifByteOrder);
                d j11 = d.j(m12 - m13, this.mExifByteOrder);
                this.mAttributes[i10].put(TAG_IMAGE_LENGTH, j10);
                this.mAttributes[i10].put(TAG_IMAGE_WIDTH, j11);
            }
        }
    }

    private void validateImages() throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        d dVar = this.mAttributes[1].get(TAG_PIXEL_X_DIMENSION);
        d dVar2 = this.mAttributes[1].get(TAG_PIXEL_Y_DIMENSION);
        if (!(dVar == null || dVar2 == null)) {
            this.mAttributes[0].put(TAG_IMAGE_WIDTH, dVar);
            this.mAttributes[0].put(TAG_IMAGE_LENGTH, dVar2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, d>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            Log.d(TAG, "No image meets the size requirements of a thumbnail image.");
        }
        replaceInvalidTags(0, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(0, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_ORIENTATION, TAG_ORIENTATION);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_LENGTH, TAG_IMAGE_LENGTH);
        replaceInvalidTags(5, TAG_THUMBNAIL_IMAGE_WIDTH, TAG_IMAGE_WIDTH);
        replaceInvalidTags(4, TAG_ORIENTATION, TAG_THUMBNAIL_ORIENTATION);
        replaceInvalidTags(4, TAG_IMAGE_LENGTH, TAG_THUMBNAIL_IMAGE_LENGTH);
        replaceInvalidTags(4, TAG_IMAGE_WIDTH, TAG_THUMBNAIL_IMAGE_WIDTH);
    }

    private int writeExifSegment(c cVar) throws IOException {
        short s10;
        c cVar2 = cVar;
        e[][] eVarArr = EXIF_TAGS;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : EXIF_POINTER_TAGS) {
            removeAttribute(eVar.f15515b);
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                removeAttribute(TAG_STRIP_OFFSETS);
                removeAttribute(TAG_STRIP_BYTE_COUNTS);
            } else {
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT);
                removeAttribute(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
            }
        }
        for (int i10 = 0; i10 < EXIF_TAGS.length; i10++) {
            for (Object obj : this.mAttributes[i10].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i10].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].f15515b, d.f(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].f15515b, d.f(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].f15515b, d.f(0, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, d.j(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_STRIP_BYTE_COUNTS, d.j(this.mThumbnailLength, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, d.f(0, this.mExifByteOrder));
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, d.f((long) this.mThumbnailLength, this.mExifByteOrder));
            }
        }
        for (int i11 = 0; i11 < EXIF_TAGS.length; i11++) {
            int i12 = 0;
            for (Map.Entry<String, d> value : this.mAttributes[i11].entrySet()) {
                int p10 = ((d) value.getValue()).p();
                if (p10 > 4) {
                    i12 += p10;
                }
            }
            iArr2[i11] = iArr2[i11] + i12;
        }
        int i13 = 8;
        for (int i14 = 0; i14 < EXIF_TAGS.length; i14++) {
            if (!this.mAttributes[i14].isEmpty()) {
                iArr[i14] = i13;
                i13 += (this.mAttributes[i14].size() * 12) + 6 + iArr2[i14];
            }
        }
        if (this.mHasThumbnail) {
            if (this.mHasThumbnailStrips) {
                this.mAttributes[4].put(TAG_STRIP_OFFSETS, d.j(i13, this.mExifByteOrder));
            } else {
                this.mAttributes[4].put(TAG_JPEG_INTERCHANGE_FORMAT, d.f((long) i13, this.mExifByteOrder));
            }
            this.mThumbnailOffset = i13;
            i13 += this.mThumbnailLength;
        }
        if (this.mMimeType == 4) {
            i13 += 8;
        }
        if (DEBUG) {
            for (int i15 = 0; i15 < EXIF_TAGS.length; i15++) {
                Log.d(TAG, String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i15), Integer.valueOf(iArr[i15]), Integer.valueOf(this.mAttributes[i15].size()), Integer.valueOf(iArr2[i15]), Integer.valueOf(i13)}));
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].f15515b, d.f((long) iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].f15515b, d.f((long) iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].f15515b, d.f((long) iArr[3], this.mExifByteOrder));
        }
        int i16 = this.mMimeType;
        if (i16 == 4) {
            cVar2.m(i13);
            cVar2.write(IDENTIFIER_EXIF_APP1);
        } else if (i16 == 13) {
            cVar2.h(i13);
            cVar2.write(PNG_CHUNK_TYPE_EXIF);
        } else if (i16 == 14) {
            cVar2.write(WEBP_CHUNK_TYPE_EXIF);
            cVar2.h(i13);
        }
        if (this.mExifByteOrder == ByteOrder.BIG_ENDIAN) {
            s10 = BYTE_ALIGN_MM;
        } else {
            s10 = BYTE_ALIGN_II;
        }
        cVar2.j(s10);
        cVar2.a(this.mExifByteOrder);
        cVar2.m(42);
        cVar2.k(8);
        for (int i17 = 0; i17 < EXIF_TAGS.length; i17++) {
            if (!this.mAttributes[i17].isEmpty()) {
                cVar2.m(this.mAttributes[i17].size());
                int size = iArr[i17] + 2 + (this.mAttributes[i17].size() * 12) + 4;
                for (Map.Entry next : this.mAttributes[i17].entrySet()) {
                    int i18 = sExifTagMapsForWriting[i17].get(next.getKey()).f15514a;
                    d dVar = (d) next.getValue();
                    int p11 = dVar.p();
                    cVar2.m(i18);
                    cVar2.m(dVar.f15510a);
                    cVar2.h(dVar.f15511b);
                    if (p11 > 4) {
                        cVar2.k((long) size);
                        size += p11;
                    } else {
                        cVar2.write(dVar.f15513d);
                        if (p11 < 4) {
                            while (p11 < 4) {
                                cVar2.b(0);
                                p11++;
                            }
                        }
                    }
                }
                if (i17 != 0 || this.mAttributes[4].isEmpty()) {
                    cVar2.k(0);
                } else {
                    cVar2.k((long) iArr[4]);
                }
                for (Map.Entry<String, d> value2 : this.mAttributes[i17].entrySet()) {
                    byte[] bArr = ((d) value2.getValue()).f15513d;
                    if (bArr.length > 4) {
                        cVar2.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            cVar2.write(getThumbnailBytes());
        }
        if (this.mMimeType == 14 && i13 % 2 == 1) {
            cVar2.b(0);
        }
        cVar2.a(ByteOrder.BIG_ENDIAN);
        return i13;
    }

    public void flipHorizontally() {
        int i10 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i10 = 2;
                break;
            case 2:
                break;
            case 3:
                i10 = 4;
                break;
            case 4:
                i10 = 3;
                break;
            case 5:
                i10 = 6;
                break;
            case 6:
                i10 = 5;
                break;
            case 7:
                i10 = 8;
                break;
            case 8:
                i10 = 7;
                break;
            default:
                i10 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i10));
    }

    public void flipVertically() {
        int i10 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i10 = 4;
                break;
            case 2:
                i10 = 3;
                break;
            case 3:
                i10 = 2;
                break;
            case 4:
                break;
            case 5:
                i10 = 8;
                break;
            case 6:
                i10 = 7;
                break;
            case 7:
                i10 = 6;
                break;
            case 8:
                i10 = 5;
                break;
            default:
                i10 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i10));
    }

    public double getAltitude(double d10) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int i10 = -1;
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d10;
        }
        if (attributeInt != 1) {
            i10 = 1;
        }
        return attributeDouble * ((double) i10);
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        if (str != null) {
            d exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                if (!sTagSetForCompatibility.contains(str)) {
                    return exifAttribute.n(this.mExifByteOrder);
                }
                if (str.equals(TAG_GPS_TIMESTAMP)) {
                    int i10 = exifAttribute.f15510a;
                    if (i10 == 5 || i10 == 10) {
                        f[] fVarArr = (f[]) exifAttribute.o(this.mExifByteOrder);
                        if (fVarArr == null || fVarArr.length != 3) {
                            Log.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                            return null;
                        }
                        f fVar = fVarArr[0];
                        Integer valueOf = Integer.valueOf((int) (((float) fVar.f15518a) / ((float) fVar.f15519b)));
                        f fVar2 = fVarArr[1];
                        Integer valueOf2 = Integer.valueOf((int) (((float) fVar2.f15518a) / ((float) fVar2.f15519b)));
                        f fVar3 = fVarArr[2];
                        return String.format("%02d:%02d:%02d", new Object[]{valueOf, valueOf2, Integer.valueOf((int) (((float) fVar3.f15518a) / ((float) fVar3.f15519b)))});
                    }
                    Log.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.f15510a);
                    return null;
                }
                try {
                    return Double.toString(exifAttribute.l(this.mExifByteOrder));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    @Nullable
    public byte[] getAttributeBytes(@NonNull String str) {
        if (str != null) {
            d exifAttribute = getExifAttribute(str);
            if (exifAttribute != null) {
                return exifAttribute.f15513d;
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public double getAttributeDouble(@NonNull String str, double d10) {
        if (str != null) {
            d exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return d10;
            }
            try {
                return exifAttribute.l(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return d10;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    public int getAttributeInt(@NonNull String str, int i10) {
        if (str != null) {
            d exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return i10;
            }
            try {
                return exifAttribute.m(this.mExifByteOrder);
            } catch (NumberFormatException unused) {
                return i10;
            }
        } else {
            throw new NullPointerException("tag shouldn't be null");
        }
    }

    @Nullable
    public long[] getAttributeRange(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        } else if (!this.mModified) {
            d exifAttribute = getExifAttribute(str);
            if (exifAttribute == null) {
                return null;
            }
            return new long[]{exifAttribute.f15512c, (long) exifAttribute.f15513d.length};
        } else {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTime() {
        return parseDateTime(getAttribute(TAG_DATETIME), getAttribute(TAG_SUBSEC_TIME), getAttribute(TAG_OFFSET_TIME));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeDigitized() {
        return parseDateTime(getAttribute(TAG_DATETIME_DIGITIZED), getAttribute(TAG_SUBSEC_TIME_DIGITIZED), getAttribute(TAG_OFFSET_TIME_DIGITIZED));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Long getDateTimeOriginal() {
        return parseDateTime(getAttribute(TAG_DATETIME_ORIGINAL), getAttribute(TAG_SUBSEC_TIME_ORIGINAL), getAttribute(TAG_OFFSET_TIME_ORIGINAL));
    }

    @SuppressLint({"AutoBoxing"})
    @Nullable
    public Long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (!(attribute == null || attribute2 == null)) {
            Pattern pattern = NON_ZERO_TIME_PATTERN;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                String str = attribute + ' ' + attribute2;
                ParsePosition parsePosition = new ParsePosition(0);
                try {
                    Date parse = sFormatterPrimary.parse(str, parsePosition);
                    if (parse == null && (parse = sFormatterSecondary.parse(str, parsePosition)) == null) {
                        return null;
                    }
                    return Long.valueOf(parse.getTime());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return null;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i10 = this.mThumbnailCompression;
        if (i10 == 6 || i10 == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i10 = this.mThumbnailCompression;
        if (i10 == 6 || i10 == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i10 == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i11 = 0; i11 < length; i11++) {
                byte[] bArr = this.mThumbnailBytes;
                int i12 = i11 * 3;
                iArr[i11] = (bArr[i12] << 16) + (bArr[i12 + 1] << 8) + bArr[i12 + 2];
            }
            d dVar = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_LENGTH);
            d dVar2 = this.mAttributes[4].get(TAG_THUMBNAIL_IMAGE_WIDTH);
            if (!(dVar == null || dVar2 == null)) {
                return Bitmap.createBitmap(iArr, dVar2.m(this.mExifByteOrder), dVar.m(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006f A[SYNTHETIC, Splitter:B:38:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0090 A[Catch:{ Exception -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b0  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getThumbnailBytes() {
        /*
            r9 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r9.mHasThumbnail
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            byte[] r1 = r9.mThumbnailBytes
            if (r1 == 0) goto L_0x000d
            return r1
        L_0x000d:
            android.content.res.AssetManager$AssetInputStream r1 = r9.mAssetInputStream     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            if (r1 == 0) goto L_0x002f
            boolean r3 = r1.markSupported()     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            if (r3 == 0) goto L_0x0026
            r1.reset()     // Catch:{ Exception -> 0x0021, all -> 0x001c }
        L_0x001a:
            r3 = r2
            goto L_0x0059
        L_0x001c:
            r0 = move-exception
            r3 = r2
        L_0x001e:
            r2 = r1
            goto L_0x00ab
        L_0x0021:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L_0x009d
        L_0x0026:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            androidx.exifinterface.media.a.c(r1)
            return r2
        L_0x002f:
            java.lang.String r1 = r9.mFilename     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            if (r1 == 0) goto L_0x0044
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            java.lang.String r3 = r9.mFilename     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            r1.<init>(r3)     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            goto L_0x001a
        L_0x003b:
            r0 = move-exception
            r3 = r2
            goto L_0x00ab
        L_0x003f:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
            goto L_0x009d
        L_0x0044:
            java.io.FileDescriptor r1 = r9.mSeekableFileDescriptor     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            java.io.FileDescriptor r1 = androidx.exifinterface.media.a.C0200a.b(r1)     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            int r3 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r4 = 0
            androidx.exifinterface.media.a.C0200a.c(r1, r4, r3)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
            r8 = r3
            r3 = r1
            r1 = r8
        L_0x0059:
            int r4 = r9.mThumbnailOffset     // Catch:{ Exception -> 0x0088 }
            int r5 = r9.mOffsetToExifData     // Catch:{ Exception -> 0x0088 }
            int r4 = r4 + r5
            long r4 = (long) r4     // Catch:{ Exception -> 0x0088 }
            long r4 = r1.skip(r4)     // Catch:{ Exception -> 0x0088 }
            int r6 = r9.mThumbnailOffset     // Catch:{ Exception -> 0x0088 }
            int r7 = r9.mOffsetToExifData     // Catch:{ Exception -> 0x0088 }
            int r6 = r6 + r7
            long r6 = (long) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            java.lang.String r5 = "Corrupted image"
            if (r4 != 0) goto L_0x0090
            int r4 = r9.mThumbnailLength     // Catch:{ Exception -> 0x0088 }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0088 }
            int r6 = r1.read(r4)     // Catch:{ Exception -> 0x0088 }
            int r7 = r9.mThumbnailLength     // Catch:{ Exception -> 0x0088 }
            if (r6 != r7) goto L_0x008a
            r9.mThumbnailBytes = r4     // Catch:{ Exception -> 0x0088 }
            androidx.exifinterface.media.a.c(r1)
            if (r3 == 0) goto L_0x0085
            androidx.exifinterface.media.a.b(r3)
        L_0x0085:
            return r4
        L_0x0086:
            r0 = move-exception
            goto L_0x001e
        L_0x0088:
            r4 = move-exception
            goto L_0x009d
        L_0x008a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x0088 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0088 }
            throw r4     // Catch:{ Exception -> 0x0088 }
        L_0x0090:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x0088 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0088 }
            throw r4     // Catch:{ Exception -> 0x0088 }
        L_0x0096:
            r0 = move-exception
            r3 = r1
            goto L_0x00ab
        L_0x0099:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
        L_0x009d:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch:{ all -> 0x0086 }
            androidx.exifinterface.media.a.c(r1)
            if (r3 == 0) goto L_0x00aa
            androidx.exifinterface.media.a.b(r3)
        L_0x00aa:
            return r2
        L_0x00ab:
            androidx.exifinterface.media.a.c(r2)
            if (r3 == 0) goto L_0x00b3
            androidx.exifinterface.media.a.b(r3)
        L_0x00b3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.getThumbnailBytes():byte[]");
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (this.mModified) {
            throw new IllegalStateException("The underlying file has been modified since being parsed");
        } else if (!this.mHasThumbnail) {
            return null;
        } else {
            if (this.mHasThumbnailStrips && !this.mAreThumbnailStripsConsecutive) {
                return null;
            }
            return new long[]{(long) (this.mThumbnailOffset + this.mOffsetToExifData), (long) this.mThumbnailLength};
        }
    }

    public boolean hasAttribute(@NonNull String str) {
        if (getExifAttribute(str) != null) {
            return true;
        }
        return false;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        if (attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5) {
            return true;
        }
        return false;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int i10 = this.mThumbnailCompression;
        if (i10 == 6 || i10 == 7) {
            return true;
        }
        return false;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i10) {
        if (i10 % 90 == 0) {
            int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
            List<Integer> list = ROTATION_ORDER;
            int i11 = 0;
            if (list.contains(Integer.valueOf(attributeInt))) {
                int indexOf = (list.indexOf(Integer.valueOf(attributeInt)) + (i10 / 90)) % 4;
                if (indexOf < 0) {
                    i11 = 4;
                }
                i11 = list.get(indexOf + i11).intValue();
            } else {
                List<Integer> list2 = FLIPPED_ROTATION_ORDER;
                if (list2.contains(Integer.valueOf(attributeInt))) {
                    int indexOf2 = (list2.indexOf(Integer.valueOf(attributeInt)) + (i10 / 90)) % 4;
                    if (indexOf2 < 0) {
                        i11 = 4;
                    }
                    i11 = list2.get(indexOf2 + i11).intValue();
                }
            }
            setAttribute(TAG_ORIENTATION, Integer.toString(i11));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r6v8, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0162, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0084, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0085, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ee, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ef, code lost:
        r9 = null;
        r1 = r6;
        r6 = r8;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f4, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f5, code lost:
        r8 = null;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0101, code lost:
        androidx.exifinterface.media.a.C0200a.c(r13.mSeekableFileDescriptor, 0, android.system.OsConstants.SEEK_SET);
        r1 = new java.io.FileOutputStream(r13.mSeekableFileDescriptor);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0116, code lost:
        r1 = new java.io.FileOutputStream(r13.mFilename);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084 A[Catch:{ Exception -> 0x0088, all -> 0x0084 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:31:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0101 A[Catch:{ Exception -> 0x0114, all -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0116 A[Catch:{ Exception -> 0x0114, all -> 0x0111 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveAttributes() throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r13.mMimeType
            boolean r0 = isSupportedFormatForSavingAttributes(r0)
            if (r0 == 0) goto L_0x0182
            java.io.FileDescriptor r0 = r13.mSeekableFileDescriptor
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r13.mFilename
            if (r0 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0019:
            boolean r0 = r13.mHasThumbnail
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.mHasThumbnailStrips
            if (r0 == 0) goto L_0x002e
            boolean r0 = r13.mAreThumbnailStripsConsecutive
            if (r0 == 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            r0 = 1
            r13.mModified = r0
            byte[] r1 = r13.getThumbnail()
            r13.mThumbnailBytes = r1
            r1 = 0
            java.lang.String r2 = "temp"
            java.lang.String r3 = "tmp"
            java.io.File r2 = java.io.File.createTempFile(r2, r3)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.lang.String r3 = r13.mFilename     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r4 = 0
            if (r3 == 0) goto L_0x0056
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.lang.String r6 = r13.mFilename     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            goto L_0x0064
        L_0x004e:
            r0 = move-exception
            r6 = r1
            goto L_0x017b
        L_0x0052:
            r0 = move-exception
            r6 = r1
            goto L_0x0172
        L_0x0056:
            java.io.FileDescriptor r3 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            androidx.exifinterface.media.a.C0200a.c(r3, r4, r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.FileDescriptor r6 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
        L_0x0064:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x016f, all -> 0x016c }
            r6.<init>(r2)     // Catch:{ Exception -> 0x016f, all -> 0x016c }
            androidx.exifinterface.media.a.e(r3, r6)     // Catch:{ Exception -> 0x0169, all -> 0x0166 }
            androidx.exifinterface.media.a.c(r3)
            androidx.exifinterface.media.a.c(r6)
            r3 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00f4, all -> 0x0084 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x00f4, all -> 0x0084 }
            java.lang.String r7 = r13.mFilename     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            if (r7 == 0) goto L_0x0090
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.lang.String r8 = r13.mFilename     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            goto L_0x009e
        L_0x0084:
            r0 = move-exception
            r9 = r1
            goto L_0x015a
        L_0x0088:
            r7 = move-exception
            r8 = r1
            r9 = r8
            r1 = r6
        L_0x008c:
            r6 = r7
            r7 = r9
            goto L_0x00f8
        L_0x0090:
            java.io.FileDescriptor r7 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            int r8 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            androidx.exifinterface.media.a.C0200a.c(r7, r4, r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            java.io.FileDescriptor r8 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0088, all -> 0x0084 }
        L_0x009e:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00ee, all -> 0x0084 }
            r8.<init>(r6)     // Catch:{ Exception -> 0x00ee, all -> 0x0084 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
            int r10 = r13.mMimeType     // Catch:{ Exception -> 0x00b5 }
            r11 = 4
            if (r10 != r11) goto L_0x00ba
            r13.saveJpegAttributes(r8, r9)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00d9
        L_0x00b1:
            r0 = move-exception
        L_0x00b2:
            r1 = r8
            goto L_0x015a
        L_0x00b5:
            r1 = move-exception
            r12 = r6
            r6 = r1
            r1 = r12
            goto L_0x00f8
        L_0x00ba:
            r11 = 13
            if (r10 != r11) goto L_0x00c2
            r13.savePngAttributes(r8, r9)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00d9
        L_0x00c2:
            r11 = 14
            if (r10 != r11) goto L_0x00ca
            r13.saveWebpAttributes(r8, r9)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00d9
        L_0x00ca:
            r11 = 3
            if (r10 == r11) goto L_0x00cf
            if (r10 != 0) goto L_0x00d9
        L_0x00cf:
            androidx.exifinterface.media.ExifInterface$c r10 = new androidx.exifinterface.media.ExifInterface$c     // Catch:{ Exception -> 0x00b5 }
            java.nio.ByteOrder r11 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ Exception -> 0x00b5 }
            r10.<init>(r9, r11)     // Catch:{ Exception -> 0x00b5 }
            r13.writeExifSegment(r10)     // Catch:{ Exception -> 0x00b5 }
        L_0x00d9:
            androidx.exifinterface.media.a.c(r8)
            androidx.exifinterface.media.a.c(r9)
            r2.delete()
            r13.mThumbnailBytes = r1
            return
        L_0x00e5:
            r0 = move-exception
            r9 = r1
            goto L_0x00b2
        L_0x00e8:
            r9 = move-exception
            r12 = r9
            r9 = r1
            r1 = r6
            r6 = r12
            goto L_0x00f8
        L_0x00ee:
            r8 = move-exception
            r9 = r1
            r1 = r6
            r6 = r8
            r8 = r9
            goto L_0x00f8
        L_0x00f4:
            r7 = move-exception
            r8 = r1
            r9 = r8
            goto L_0x008c
        L_0x00f8:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0131, all -> 0x012f }
            r10.<init>(r2)     // Catch:{ Exception -> 0x0131, all -> 0x012f }
            java.lang.String r1 = r13.mFilename     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            if (r1 != 0) goto L_0x0116
            java.io.FileDescriptor r1 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            int r11 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            androidx.exifinterface.media.a.C0200a.c(r1, r4, r11)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.io.FileDescriptor r4 = r13.mSeekableFileDescriptor     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
        L_0x010f:
            r7 = r1
            goto L_0x011e
        L_0x0111:
            r0 = move-exception
        L_0x0112:
            r1 = r10
            goto L_0x0153
        L_0x0114:
            r1 = move-exception
            goto L_0x0134
        L_0x0116:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            java.lang.String r4 = r13.mFilename     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            goto L_0x010f
        L_0x011e:
            androidx.exifinterface.media.a.e(r10, r7)     // Catch:{ Exception -> 0x0114, all -> 0x0111 }
            androidx.exifinterface.media.a.c(r10)     // Catch:{ all -> 0x00b1 }
            androidx.exifinterface.media.a.c(r7)     // Catch:{ all -> 0x00b1 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00b1 }
            java.lang.String r1 = "Failed to save new file"
            r0.<init>(r1, r6)     // Catch:{ all -> 0x00b1 }
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x012f:
            r0 = move-exception
            goto L_0x0153
        L_0x0131:
            r3 = move-exception
            r10 = r1
            r1 = r3
        L_0x0134:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x014f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x014f }
            r4.<init>()     // Catch:{ all -> 0x014f }
            java.lang.String r5 = "Failed to save new file. Original file is stored in "
            r4.append(r5)     // Catch:{ all -> 0x014f }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x014f }
            r4.append(r5)     // Catch:{ all -> 0x014f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x014f }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x014f }
            throw r3     // Catch:{ all -> 0x014f }
        L_0x014f:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L_0x0112
        L_0x0153:
            androidx.exifinterface.media.a.c(r1)     // Catch:{ all -> 0x00b1 }
            androidx.exifinterface.media.a.c(r7)     // Catch:{ all -> 0x00b1 }
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x015a:
            androidx.exifinterface.media.a.c(r1)
            androidx.exifinterface.media.a.c(r9)
            if (r3 != 0) goto L_0x0165
            r2.delete()
        L_0x0165:
            throw r0
        L_0x0166:
            r0 = move-exception
        L_0x0167:
            r1 = r3
            goto L_0x017b
        L_0x0169:
            r0 = move-exception
        L_0x016a:
            r1 = r3
            goto L_0x0172
        L_0x016c:
            r0 = move-exception
            r6 = r1
            goto L_0x0167
        L_0x016f:
            r0 = move-exception
            r6 = r1
            goto L_0x016a
        L_0x0172:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x017a }
            java.lang.String r3 = "Failed to copy original file to temp file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x017a }
            throw r2     // Catch:{ all -> 0x017a }
        L_0x017a:
            r0 = move-exception
        L_0x017b:
            androidx.exifinterface.media.a.c(r1)
            androidx.exifinterface.media.a.c(r6)
            throw r0
        L_0x0182:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes for JPEG, PNG, WebP, and DNG formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.saveAttributes():void");
    }

    public void setAltitude(double d10) {
        String str;
        if (d10 >= 0.0d) {
            str = "0";
        } else {
            str = "1";
        }
        setAttribute(TAG_GPS_ALTITUDE, new f(Math.abs(d10)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0295, code lost:
        r15 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAttribute(@androidx.annotation.NonNull java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            if (r1 == 0) goto L_0x0365
            java.lang.String r3 = "DateTime"
            boolean r3 = r3.equals(r1)
            java.lang.String r4 = " : "
            java.lang.String r5 = "Invalid value for "
            java.lang.String r6 = "ExifInterface"
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeOriginal"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0026
            java.lang.String r3 = "DateTimeDigitized"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x006d
        L_0x0026:
            if (r2 == 0) goto L_0x006d
            java.util.regex.Pattern r3 = DATETIME_PRIMARY_FORMAT_PATTERN
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r3 = r3.find()
            java.util.regex.Pattern r7 = DATETIME_SECONDARY_FORMAT_PATTERN
            java.util.regex.Matcher r7 = r7.matcher(r2)
            boolean r7 = r7.find()
            int r8 = r19.length()
            r9 = 19
            if (r8 != r9) goto L_0x0054
            if (r3 != 0) goto L_0x0049
            if (r7 != 0) goto L_0x0049
            goto L_0x0054
        L_0x0049:
            if (r7 == 0) goto L_0x006d
            java.lang.String r3 = "-"
            java.lang.String r7 = ":"
            java.lang.String r2 = r2.replaceAll(r3, r7)
            goto L_0x006d
        L_0x0054:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x006d:
            java.lang.String r3 = "ISOSpeedRatings"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0080
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY."
            android.util.Log.d(r6, r1)
        L_0x007e:
            java.lang.String r1 = "PhotographicSensitivity"
        L_0x0080:
            r3 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0119
            java.util.HashSet<java.lang.String> r8 = sTagSetForCompatibility
            boolean r8 = r8.contains(r1)
            if (r8 == 0) goto L_0x0119
            java.lang.String r8 = "GPSTimeStamp"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x00f2
            java.util.regex.Pattern r8 = GPS_TIMESTAMP_PATTERN
            java.util.regex.Matcher r8 = r8.matcher(r2)
            boolean r9 = r8.find()
            if (r9 != 0) goto L_0x00b9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x00b9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r8.group(r7)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1,"
            r2.append(r4)
            java.lang.String r5 = r8.group(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            r2.append(r5)
            r2.append(r4)
            r4 = 3
            java.lang.String r4 = r8.group(r4)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x0119
        L_0x00f2:
            double r8 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x0100 }
            androidx.exifinterface.media.ExifInterface$f r10 = new androidx.exifinterface.media.ExifInterface$f     // Catch:{ NumberFormatException -> 0x0100 }
            r10.<init>(r8)     // Catch:{ NumberFormatException -> 0x0100 }
            java.lang.String r2 = r10.toString()     // Catch:{ NumberFormatException -> 0x0100 }
            goto L_0x0119
        L_0x0100:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x0119:
            r4 = 0
            r5 = r4
        L_0x011b:
            androidx.exifinterface.media.ExifInterface$e[][] r8 = EXIF_TAGS
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0364
            r8 = 4
            if (r5 != r8) goto L_0x012a
            boolean r8 = r0.mHasThumbnail
            if (r8 != 0) goto L_0x012a
        L_0x0127:
            r15 = r7
            goto L_0x035d
        L_0x012a:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$e>[] r8 = sExifTagMapsForWriting
            r8 = r8[r5]
            java.lang.Object r8 = r8.get(r1)
            androidx.exifinterface.media.ExifInterface$e r8 = (androidx.exifinterface.media.ExifInterface.e) r8
            if (r8 == 0) goto L_0x0127
            if (r2 != 0) goto L_0x0140
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r8 = r0.mAttributes
            r8 = r8[r5]
            r8.remove(r1)
            goto L_0x0127
        L_0x0140:
            android.util.Pair r9 = guessDataFormat(r2)
            int r10 = r8.f15516c
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r12 = -1
            if (r10 == r11) goto L_0x0210
            int r10 = r8.f15516c
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x015f
            goto L_0x0210
        L_0x015f:
            int r10 = r8.f15517d
            if (r10 == r12) goto L_0x017d
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 == r11) goto L_0x0179
            int r10 = r8.f15517d
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x017d
        L_0x0179:
            int r8 = r8.f15517d
            goto L_0x0212
        L_0x017d:
            int r10 = r8.f15516c
            if (r10 == r7) goto L_0x020e
            r11 = 7
            if (r10 == r11) goto L_0x020e
            if (r10 != r3) goto L_0x0188
            goto L_0x020e
        L_0x0188:
            boolean r10 = DEBUG
            if (r10 == 0) goto L_0x0127
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Given tag ("
            r10.append(r11)
            r10.append(r1)
            java.lang.String r11 = ") value didn't match with one of expected formats: "
            r10.append(r11)
            java.lang.String[] r11 = IFD_FORMAT_NAMES
            int r13 = r8.f15516c
            r13 = r11[r13]
            r10.append(r13)
            int r13 = r8.f15517d
            java.lang.String r14 = ", "
            java.lang.String r15 = ""
            if (r13 != r12) goto L_0x01b1
            r8 = r15
            goto L_0x01c4
        L_0x01b1:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r14)
            int r8 = r8.f15517d
            r8 = r11[r8]
            r13.append(r8)
            java.lang.String r8 = r13.toString()
        L_0x01c4:
            r10.append(r8)
            java.lang.String r8 = " (guess: "
            r10.append(r8)
            java.lang.Object r8 = r9.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r8 = r11[r8]
            r10.append(r8)
            java.lang.Object r8 = r9.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 != r12) goto L_0x01e4
            goto L_0x01fd
        L_0x01e4:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r14)
            java.lang.Object r9 = r9.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r9 = r11[r9]
            r8.append(r9)
            java.lang.String r15 = r8.toString()
        L_0x01fd:
            r10.append(r15)
            java.lang.String r8 = ")"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            android.util.Log.d(r6, r8)
            goto L_0x0127
        L_0x020e:
            r8 = r10
            goto L_0x0212
        L_0x0210:
            int r8 = r8.f15516c
        L_0x0212:
            java.lang.String r9 = "/"
            java.lang.String r10 = ","
            switch(r8) {
                case 1: goto L_0x0351;
                case 2: goto L_0x0344;
                case 3: goto L_0x031e;
                case 4: goto L_0x02f8;
                case 5: goto L_0x02bc;
                case 6: goto L_0x0219;
                case 7: goto L_0x0344;
                case 8: goto L_0x0219;
                case 9: goto L_0x0298;
                case 10: goto L_0x0258;
                case 11: goto L_0x0219;
                case 12: goto L_0x0233;
                default: goto L_0x0219;
            }
        L_0x0219:
            boolean r9 = DEBUG
            if (r9 == 0) goto L_0x0127
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Data format isn't one of expected formats: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            android.util.Log.d(r6, r8)
            goto L_0x0127
        L_0x0233:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r9 = r8.length
            double[] r9 = new double[r9]
            r10 = r4
        L_0x023b:
            int r11 = r8.length
            if (r10 >= r11) goto L_0x0249
            r11 = r8[r10]
            double r11 = java.lang.Double.parseDouble(r11)
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x023b
        L_0x0249:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r8 = r0.mAttributes
            r8 = r8[r5]
            java.nio.ByteOrder r10 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r9 = androidx.exifinterface.media.ExifInterface.d.b(r9, r10)
            r8.put(r1, r9)
            goto L_0x0127
        L_0x0258:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r10 = r8.length
            androidx.exifinterface.media.ExifInterface$f[] r10 = new androidx.exifinterface.media.ExifInterface.f[r10]
            r11 = r4
        L_0x0260:
            int r13 = r8.length
            if (r11 >= r13) goto L_0x0288
            r13 = r8[r11]
            java.lang.String[] r13 = r13.split(r9, r12)
            androidx.exifinterface.media.ExifInterface$f r14 = new androidx.exifinterface.media.ExifInterface$f
            r15 = r13[r4]
            double r3 = java.lang.Double.parseDouble(r15)
            long r3 = (long) r3
            r13 = r13[r7]
            r16 = r8
            double r7 = java.lang.Double.parseDouble(r13)
            long r7 = (long) r7
            r14.<init>(r3, r7)
            r10[r11] = r14
            int r11 = r11 + 1
            r8 = r16
            r3 = 2
            r4 = 0
            r7 = 1
            goto L_0x0260
        L_0x0288:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r4 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r4 = androidx.exifinterface.media.ExifInterface.d.d(r10, r4)
            r3.put(r1, r4)
        L_0x0295:
            r15 = 1
            goto L_0x035d
        L_0x0298:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x02a0:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02ae
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x02a0
        L_0x02ae:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r4 = androidx.exifinterface.media.ExifInterface.d.c(r4, r7)
            r3.put(r1, r4)
            goto L_0x0295
        L_0x02bc:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            androidx.exifinterface.media.ExifInterface$f[] r4 = new androidx.exifinterface.media.ExifInterface.f[r4]
            r7 = 0
        L_0x02c4:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02e8
            r8 = r3[r7]
            java.lang.String[] r8 = r8.split(r9, r12)
            androidx.exifinterface.media.ExifInterface$f r10 = new androidx.exifinterface.media.ExifInterface$f
            r11 = 0
            r13 = r8[r11]
            double r13 = java.lang.Double.parseDouble(r13)
            long r13 = (long) r13
            r15 = 1
            r8 = r8[r15]
            double r11 = java.lang.Double.parseDouble(r8)
            long r11 = (long) r11
            r10.<init>(r13, r11)
            r4[r7] = r10
            int r7 = r7 + 1
            r12 = -1
            goto L_0x02c4
        L_0x02e8:
            r15 = 1
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r4 = androidx.exifinterface.media.ExifInterface.d.i(r4, r7)
            r3.put(r1, r4)
            goto L_0x035d
        L_0x02f8:
            r15 = r7
            r3 = r12
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            long[] r4 = new long[r4]
            r7 = 0
        L_0x0302:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0310
            r8 = r3[r7]
            long r8 = java.lang.Long.parseLong(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0302
        L_0x0310:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r4 = androidx.exifinterface.media.ExifInterface.d.g(r4, r7)
            r3.put(r1, r4)
            goto L_0x035d
        L_0x031e:
            r15 = r7
            r3 = r12
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x0328:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0336
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0328
        L_0x0336:
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.mExifByteOrder
            androidx.exifinterface.media.ExifInterface$d r4 = androidx.exifinterface.media.ExifInterface.d.k(r4, r7)
            r3.put(r1, r4)
            goto L_0x035d
        L_0x0344:
            r15 = r7
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r5]
            androidx.exifinterface.media.ExifInterface$d r4 = androidx.exifinterface.media.ExifInterface.d.e(r2)
            r3.put(r1, r4)
            goto L_0x035d
        L_0x0351:
            r15 = r7
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.ExifInterface$d>[] r3 = r0.mAttributes
            r3 = r3[r5]
            androidx.exifinterface.media.ExifInterface$d r4 = androidx.exifinterface.media.ExifInterface.d.a(r2)
            r3.put(r1, r4)
        L_0x035d:
            int r5 = r5 + 1
            r7 = r15
            r3 = 2
            r4 = 0
            goto L_0x011b
        L_0x0364:
            return
        L_0x0365:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "tag shouldn't be null"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.setAttribute(java.lang.String, java.lang.String):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(@NonNull Long l10) {
        if (l10 == null) {
            throw new NullPointerException("Timestamp should not be null.");
        } else if (l10.longValue() >= 0) {
            String l11 = Long.toString(l10.longValue() % 1000);
            for (int length = l11.length(); length < 3; length++) {
                l11 = "0" + l11;
            }
            setAttribute(TAG_DATETIME, sFormatterPrimary.format(new Date(l10.longValue())));
            setAttribute(TAG_SUBSEC_TIME, l11);
        } else {
            throw new IllegalArgumentException("Timestamp should a positive value.");
        }
    }

    public void setGpsInfo(Location location) {
        if (location != null) {
            setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
            setLatLong(location.getLatitude(), location.getLongitude());
            setAltitude(location.getAltitude());
            setAttribute(TAG_GPS_SPEED_REF, "K");
            setAttribute(TAG_GPS_SPEED, new f((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = sFormatterPrimary.format(new Date(location.getTime())).split("\\s+", -1);
            setAttribute(TAG_GPS_DATESTAMP, split[0]);
            setAttribute(TAG_GPS_TIMESTAMP, split[1]);
        }
    }

    public void setLatLong(double d10, double d11) {
        String str;
        String str2;
        if (d10 < -90.0d || d10 > 90.0d || Double.isNaN(d10)) {
            throw new IllegalArgumentException("Latitude value " + d10 + " is not valid.");
        } else if (d11 < -180.0d || d11 > 180.0d || Double.isNaN(d11)) {
            throw new IllegalArgumentException("Longitude value " + d11 + " is not valid.");
        } else {
            if (d10 >= 0.0d) {
                str = "N";
            } else {
                str = "S";
            }
            setAttribute(TAG_GPS_LATITUDE_REF, str);
            setAttribute(TAG_GPS_LATITUDE, convertDecimalDegree(Math.abs(d10)));
            if (d11 >= 0.0d) {
                str2 = LONGITUDE_EAST;
            } else {
                str2 = LONGITUDE_WEST;
            }
            setAttribute(TAG_GPS_LONGITUDE_REF, str2);
            setAttribute(TAG_GPS_LONGITUDE, convertDecimalDegree(Math.abs(d11)));
        }
    }

    private static class g extends b {
        g(byte[] bArr) {
            super(bArr);
            this.f15504a.mark(Integer.MAX_VALUE);
        }

        public void k(long j10) {
            int i10 = this.f15506c;
            if (((long) i10) > j10) {
                this.f15506c = 0;
                this.f15504a.reset();
            } else {
                j10 -= (long) i10;
            }
            j((int) j10);
        }

        g(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f15504a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            Log.w(TAG, "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{attribute, attribute2, attribute3, attribute4}));
            return null;
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f15514a;

        /* renamed from: b  reason: collision with root package name */
        public final String f15515b;

        /* renamed from: c  reason: collision with root package name */
        public final int f15516c;

        /* renamed from: d  reason: collision with root package name */
        public final int f15517d;

        e(String str, int i10, int i11) {
            this.f15515b = str;
            this.f15514a = i10;
            this.f15516c = i11;
            this.f15517d = -1;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i10) {
            int i11;
            int i12 = this.f15516c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f15517d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            if ((i12 == 12 || i11 == 12) && i10 == 11) {
                return true;
            }
            return false;
        }

        e(String str, int i10, int i11, int i12) {
            this.f15515b = str;
            this.f15514a = i10;
            this.f15516c = i11;
            this.f15517d = i12;
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        e[][] eVarArr = EXIF_TAGS;
        this.mAttributes = new HashMap[eVarArr.length];
        this.mAttributesOffsets = new HashSet(eVarArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (str != null) {
            initForFilename(str);
            return;
        }
        throw new NullPointerException("filename cannot be null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExifInterface(@androidx.annotation.NonNull java.io.FileDescriptor r5) throws java.io.IOException {
        /*
            r4 = this;
            r4.<init>()
            androidx.exifinterface.media.ExifInterface$e[][] r0 = EXIF_TAGS
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r4.mAttributes = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r4.mAttributesOffsets = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r4.mExifByteOrder = r0
            if (r5 == 0) goto L_0x0057
            r0 = 0
            r4.mAssetInputStream = r0
            r4.mFilename = r0
            boolean r1 = isSeekableFD(r5)
            if (r1 == 0) goto L_0x0034
            r4.mSeekableFileDescriptor = r5
            java.io.FileDescriptor r5 = androidx.exifinterface.media.a.C0200a.b(r5)     // Catch:{ Exception -> 0x002b }
            r1 = 1
            goto L_0x0037
        L_0x002b:
            r5 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to duplicate file descriptor"
            r0.<init>(r1, r5)
            throw r0
        L_0x0034:
            r4.mSeekableFileDescriptor = r0
            r1 = 0
        L_0x0037:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x004a }
            r2.<init>(r5)     // Catch:{ all -> 0x004a }
            r4.loadAttributes(r2)     // Catch:{ all -> 0x0048 }
            androidx.exifinterface.media.a.c(r2)
            if (r1 == 0) goto L_0x0047
            androidx.exifinterface.media.a.b(r5)
        L_0x0047:
            return
        L_0x0048:
            r0 = move-exception
            goto L_0x004e
        L_0x004a:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L_0x004e:
            androidx.exifinterface.media.a.c(r2)
            if (r1 == 0) goto L_0x0056
            androidx.exifinterface.media.a.b(r5)
        L_0x0056:
            throw r0
        L_0x0057:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "fileDescriptor cannot be null"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.<init>(java.io.FileDescriptor):void");
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(@NonNull InputStream inputStream, int i10) throws IOException {
        e[][] eVarArr = EXIF_TAGS;
        this.mAttributes = new HashMap[eVarArr.length];
        this.mAttributesOffsets = new HashSet(eVarArr.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.mFilename = null;
            if (i10 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, IDENTIFIER_EXIF_APP1.length);
                if (!isExifDataOnly(bufferedInputStream)) {
                    Log.w(TAG, "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.mIsExifDataOnly = true;
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
                this.mSeekableFileDescriptor = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (isSeekableFD(fileInputStream.getFD())) {
                        this.mAssetInputStream = null;
                        this.mSeekableFileDescriptor = fileInputStream.getFD();
                    }
                }
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
