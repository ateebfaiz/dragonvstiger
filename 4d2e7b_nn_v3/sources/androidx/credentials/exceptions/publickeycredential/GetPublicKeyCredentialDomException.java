package androidx.credentials.exceptions.publickeycredential;

import androidx.annotation.RestrictTo;
import androidx.credentials.exceptions.GetCredentialCustomException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.domerrors.AbortError;
import androidx.credentials.exceptions.domerrors.ConstraintError;
import androidx.credentials.exceptions.domerrors.DataCloneError;
import androidx.credentials.exceptions.domerrors.DataError;
import androidx.credentials.exceptions.domerrors.DomError;
import androidx.credentials.exceptions.domerrors.EncodingError;
import androidx.credentials.exceptions.domerrors.HierarchyRequestError;
import androidx.credentials.exceptions.domerrors.InUseAttributeError;
import androidx.credentials.exceptions.domerrors.InvalidCharacterError;
import androidx.credentials.exceptions.domerrors.InvalidModificationError;
import androidx.credentials.exceptions.domerrors.InvalidNodeTypeError;
import androidx.credentials.exceptions.domerrors.InvalidStateError;
import androidx.credentials.exceptions.domerrors.NamespaceError;
import androidx.credentials.exceptions.domerrors.NetworkError;
import androidx.credentials.exceptions.domerrors.NoModificationAllowedError;
import androidx.credentials.exceptions.domerrors.NotAllowedError;
import androidx.credentials.exceptions.domerrors.NotFoundError;
import androidx.credentials.exceptions.domerrors.NotReadableError;
import androidx.credentials.exceptions.domerrors.NotSupportedError;
import androidx.credentials.exceptions.domerrors.OperationError;
import androidx.credentials.exceptions.domerrors.OptOutError;
import androidx.credentials.exceptions.domerrors.QuotaExceededError;
import androidx.credentials.exceptions.domerrors.ReadOnlyError;
import androidx.credentials.exceptions.domerrors.SecurityError;
import androidx.credentials.exceptions.domerrors.SyntaxError;
import androidx.credentials.exceptions.domerrors.TimeoutError;
import androidx.credentials.exceptions.domerrors.TransactionInactiveError;
import androidx.credentials.exceptions.domerrors.UnknownError;
import androidx.credentials.exceptions.domerrors.VersionError;
import androidx.credentials.exceptions.domerrors.WrongDocumentError;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class GetPublicKeyCredentialDomException extends GetPublicKeyCredentialException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION = "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION";
    private final DomError domError;

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final GetCredentialException createFrom(String str, String str2) {
            Object obj;
            m.f(str, "type");
            try {
                DomExceptionUtils.Companion companion = DomExceptionUtils.Companion;
                GetPublicKeyCredentialDomException getPublicKeyCredentialDomException = new GetPublicKeyCredentialDomException(new UnknownError(), (CharSequence) null, 2, (DefaultConstructorMarker) null);
                if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + AbortError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_ABORT_ERROR)) {
                    obj = companion.generateException(new AbortError(), str2, getPublicKeyCredentialDomException);
                } else {
                    if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + ConstraintError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_CONSTRAINT_ERROR)) {
                        obj = companion.generateException(new ConstraintError(), str2, getPublicKeyCredentialDomException);
                    } else {
                        if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + DataCloneError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_CLONE_ERROR)) {
                            obj = companion.generateException(new DataCloneError(), str2, getPublicKeyCredentialDomException);
                        } else {
                            if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + DataError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_DATA_ERROR)) {
                                obj = companion.generateException(new DataError(), str2, getPublicKeyCredentialDomException);
                            } else {
                                if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + EncodingError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_ENCODING_ERROR)) {
                                    obj = companion.generateException(new EncodingError(), str2, getPublicKeyCredentialDomException);
                                } else {
                                    if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + HierarchyRequestError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_HIERARCHY_REQUEST_ERROR)) {
                                        obj = companion.generateException(new HierarchyRequestError(), str2, getPublicKeyCredentialDomException);
                                    } else {
                                        if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + InUseAttributeError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_IN_USE_ATTRIBUTE_ERROR)) {
                                            obj = companion.generateException(new InUseAttributeError(), str2, getPublicKeyCredentialDomException);
                                        } else {
                                            if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + InvalidCharacterError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_CHARACTER_ERROR)) {
                                                obj = companion.generateException(new InvalidCharacterError(), str2, getPublicKeyCredentialDomException);
                                            } else {
                                                if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + InvalidModificationError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_MODIFICATION_ERROR)) {
                                                    obj = companion.generateException(new InvalidModificationError(), str2, getPublicKeyCredentialDomException);
                                                } else {
                                                    if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + InvalidNodeTypeError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_NODE_TYPE_ERROR)) {
                                                        obj = companion.generateException(new InvalidNodeTypeError(), str2, getPublicKeyCredentialDomException);
                                                    } else {
                                                        if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + InvalidStateError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_INVALID_STATE_ERROR)) {
                                                            obj = companion.generateException(new InvalidStateError(), str2, getPublicKeyCredentialDomException);
                                                        } else {
                                                            if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + NamespaceError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NAMESPACE_ERROR)) {
                                                                obj = companion.generateException(new NamespaceError(), str2, getPublicKeyCredentialDomException);
                                                            } else {
                                                                if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + NetworkError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NETWORK_ERROR)) {
                                                                    obj = companion.generateException(new NetworkError(), str2, getPublicKeyCredentialDomException);
                                                                } else {
                                                                    if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + NoModificationAllowedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NO_MODIFICATION_ALLOWED_ERROR)) {
                                                                        obj = companion.generateException(new NoModificationAllowedError(), str2, getPublicKeyCredentialDomException);
                                                                    } else {
                                                                        if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + NotAllowedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_ALLOWED_ERROR)) {
                                                                            obj = companion.generateException(new NotAllowedError(), str2, getPublicKeyCredentialDomException);
                                                                        } else {
                                                                            if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + NotFoundError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_FOUND_ERROR)) {
                                                                                obj = companion.generateException(new NotFoundError(), str2, getPublicKeyCredentialDomException);
                                                                            } else {
                                                                                if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + NotReadableError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_READABLE_ERROR)) {
                                                                                    obj = companion.generateException(new NotReadableError(), str2, getPublicKeyCredentialDomException);
                                                                                } else {
                                                                                    if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + NotSupportedError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_NOT_SUPPORTED_ERROR)) {
                                                                                        obj = companion.generateException(new NotSupportedError(), str2, getPublicKeyCredentialDomException);
                                                                                    } else {
                                                                                        if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + OperationError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_OPERATION_ERROR)) {
                                                                                            obj = companion.generateException(new OperationError(), str2, getPublicKeyCredentialDomException);
                                                                                        } else {
                                                                                            if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + OptOutError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_OPT_OUT_ERROR)) {
                                                                                                obj = companion.generateException(new OptOutError(), str2, getPublicKeyCredentialDomException);
                                                                                            } else {
                                                                                                if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + QuotaExceededError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_QUOTA_EXCEEDED_ERROR)) {
                                                                                                    obj = companion.generateException(new QuotaExceededError(), str2, getPublicKeyCredentialDomException);
                                                                                                } else {
                                                                                                    if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + ReadOnlyError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_READ_ONLY_ERROR)) {
                                                                                                        obj = companion.generateException(new ReadOnlyError(), str2, getPublicKeyCredentialDomException);
                                                                                                    } else {
                                                                                                        if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + SecurityError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SECURITY_ERROR)) {
                                                                                                            obj = companion.generateException(new SecurityError(), str2, getPublicKeyCredentialDomException);
                                                                                                        } else {
                                                                                                            if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + SyntaxError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_SYNTAX_ERROR)) {
                                                                                                                obj = companion.generateException(new SyntaxError(), str2, getPublicKeyCredentialDomException);
                                                                                                            } else {
                                                                                                                if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + TimeoutError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TIMEOUT_ERROR)) {
                                                                                                                    obj = companion.generateException(new TimeoutError(), str2, getPublicKeyCredentialDomException);
                                                                                                                } else {
                                                                                                                    if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + TransactionInactiveError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_TRANSACTION_INACTIVE_ERROR)) {
                                                                                                                        obj = companion.generateException(new TransactionInactiveError(), str2, getPublicKeyCredentialDomException);
                                                                                                                    } else {
                                                                                                                        if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + UnknownError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_UNKNOWN_ERROR)) {
                                                                                                                            obj = companion.generateException(new UnknownError(), str2, getPublicKeyCredentialDomException);
                                                                                                                        } else {
                                                                                                                            if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + VersionError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_VERSION_ERROR)) {
                                                                                                                                obj = companion.generateException(new VersionError(), str2, getPublicKeyCredentialDomException);
                                                                                                                            } else {
                                                                                                                                if (m.b(str, "androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + WrongDocumentError.TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_WRONG_DOCUMENT_ERROR)) {
                                                                                                                                    obj = companion.generateException(new WrongDocumentError(), str2, getPublicKeyCredentialDomException);
                                                                                                                                } else {
                                                                                                                                    throw new FrameworkClassParsingException();
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return (GetCredentialException) obj;
            } catch (FrameworkClassParsingException unused) {
                return new GetCredentialCustomException(str, str2);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetPublicKeyCredentialDomException(DomError domError2) {
        this(domError2, (CharSequence) null, 2, (DefaultConstructorMarker) null);
        m.f(domError2, "domError");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final GetCredentialException createFrom(String str, String str2) {
        return Companion.createFrom(str, str2);
    }

    public final DomError getDomError() {
        return this.domError;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetPublicKeyCredentialDomException(DomError domError2, CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(domError2, (i10 & 2) != 0 ? null : charSequence);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetPublicKeyCredentialDomException(DomError domError2, CharSequence charSequence) {
        super("androidx.credentials.TYPE_GET_PUBLIC_KEY_CREDENTIAL_DOM_EXCEPTION/" + domError2.getType(), charSequence);
        m.f(domError2, "domError");
        this.domError = domError2;
    }
}
