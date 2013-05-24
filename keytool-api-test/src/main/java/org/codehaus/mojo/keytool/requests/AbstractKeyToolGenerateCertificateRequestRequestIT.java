package org.codehaus.mojo.keytool.requests;

/*
 * Copyright 2005-2013 The Codehaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License" );
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.codehaus.mojo.keytool.KeyToolResult;

import java.io.File;

/**
 * Test the {@link org.codehaus.mojo.keytool.requests.KeyToolGenerateCertificateRequestRequest}.
 *
 * @author tchemit <chemit@codelutin.com>
 * @since 1.1
 */
public abstract class AbstractKeyToolGenerateCertificateRequestRequestIT
    extends AbstractKeyToolRequestIT<KeyToolGenerateCertificateRequestRequest>
{
    protected AbstractKeyToolGenerateCertificateRequestRequestIT()
    {
    }

    protected AbstractKeyToolGenerateCertificateRequestRequestIT( boolean supportedRequest )
    {
        super( supportedRequest );
    }

    protected abstract void requestResult( KeyToolResult keyToolResult, File keyStore, File outputFile );

    @Override
    public final void testRequest()
        throws Exception
    {

        File keyStore = resourceFixtures.simpleKeyStore();
        File outputFile = resourceFixtures.outputFile();

        KeyToolGenerateCertificateRequestRequest request =
            requestFixtures.createKeyToolGenerateCertificateRequestRequest( keyStore, outputFile );

        KeyToolResult keyToolResult = consumeRequest( request );

        requestResult( keyToolResult, keyStore, outputFile );
    }


}
