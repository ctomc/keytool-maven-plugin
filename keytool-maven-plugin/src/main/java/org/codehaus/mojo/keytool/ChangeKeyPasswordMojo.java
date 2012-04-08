package org.codehaus.mojo.keytool;

/*
 * Copyright 2005-2012 The Codehaus
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

import org.codehaus.mojo.keytool.requests.KeyToolChangeKeyPasswordRequest;
import org.codehaus.plexus.util.StringUtils;
import org.codehaus.plexus.util.cli.Commandline;

/**
 * To change the key password of an entry of a keystore.
 * <p/>
 * <p/>
 * Implemented as a wrapper around the SDK {@code keytool -keypasswd} command.
 * <p/>
 * See <a href="http://java.sun.com/j2se/1.5.0/docs/tooldocs/windows/keytool.html">keystore documentation</a>.
 *
 * @author tchemit <chemit@codelutin.com>
 * @goal changeKeyPassword
 * @requiresProject
 * @since 1.2
 */
public class ChangeKeyPasswordMojo
    extends AbstractKeyToolRequestWithKeyStoreAndAliasParametersMojo<KeyToolChangeKeyPasswordRequest>
{

    /**
     * New password.
     * <p/>
     * See <a href="http://docs.oracle.com/javase/1.5.0/docs/tooldocs/windows/keytool.html#Commands">options</a>.
     *
     * @parameter expression="${newPassword}"
     * @since 1.2
     */
    private String newPassword;

    /**
     * Key password.
     * <p/>
     * See <a href="http://docs.oracle.com/javase/1.5.0/docs/tooldocs/windows/keytool.html#Commands">options</a>.
     *
     * @parameter expression="${keypass}"
     * @since 1.2
     */
    private String keypass;

    /**
     * Default contructor.
     */
    public ChangeKeyPasswordMojo()
    {
        super( KeyToolChangeKeyPasswordRequest.class );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected KeyToolChangeKeyPasswordRequest createKeytoolRequest()
    {
        KeyToolChangeKeyPasswordRequest request = super.createKeytoolRequest();
        request.setNewPassword( this.newPassword );
        request.setKeypass( this.keypass );
        return request;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getCommandlineInfo( Commandline commandLine )
    {
        String commandLineInfo = super.getCommandlineInfo( commandLine );

        commandLineInfo = StringUtils.replace( commandLineInfo, this.keypass, "'*****'" );
        commandLineInfo = StringUtils.replace( commandLineInfo, this.newPassword, "'*****'" );

        return commandLineInfo;
    }
}
