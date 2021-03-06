/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2015
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.cf.study.webservice.restful.httpservlet.util;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;

public abstract class SerializationUtility {

    public static String toXML(final Object obj) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final XMLEncoder encoder = new XMLEncoder(out);
        encoder.writeObject(obj);
        encoder.close();
        return out.toString();
    }

}
