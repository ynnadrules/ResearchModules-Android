import java_swift
import Foundation
import AnyCodable

public class FlankerKitCore {
  public static func bootstrap(cachePath: String?) {
    setenv("TMPDIR", cachePath!, 1)
    // Required for SSL to work
    setenv("URLSessionCertificateAuthorityInfoFile", cachePath! + "/cacert.pem", 1)
  }

  public static func diagnostics() -> String {
    return Bundle.main.bundlePath
  }
}
