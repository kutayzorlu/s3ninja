/*
 * Made with all the love in the world
 * by scireum in Remshalden, Germany
 *
 * Copyright by scireum GmbH
 * http://www.scireum.de - info@scireum.de
 */

package ninja.queries;

import ninja.errors.S3ErrorCode;
import ninja.errors.S3ErrorSynthesizer;
import sirius.kernel.di.std.Part;
import sirius.kernel.di.std.Register;
import sirius.web.http.WebContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Synthesises <a href="https://docs.aws.amazon.com/AmazonS3/latest/API/API_GetBucketLifecycle">bucket lifecycle</a>
 * responses.
 */
@Register(name = "lifecycle")
public class BucketLifecycleSynthesizer implements S3QuerySynthesizer {

    @Part
    private S3ErrorSynthesizer errorSynthesizer;

    @Override
    public void processQuery(@Nonnull WebContext ctx,
                             @Nullable String bucket,
                             @Nullable String key,
                             @Nonnull String query) {
        errorSynthesizer.synthesiseError(ctx,
                                         bucket,
                                         key,
                                         S3ErrorCode.NoSuchLifecycleConfiguration,
                                         "There is no lifecycle configuration.");
    }
}
