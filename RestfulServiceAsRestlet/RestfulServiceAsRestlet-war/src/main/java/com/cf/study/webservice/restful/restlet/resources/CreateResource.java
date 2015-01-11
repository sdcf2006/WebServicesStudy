package com.cf.study.webservice.restful.restlet.resources;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.cf.study.webservice.restful.restlet.Adages;

public class CreateResource extends ServerResource {

    @Post
    public Representation create(final Representation data) {
        Status status = null;
        String msg = null;

        final Form form = new Form(data);
        final String words = form.getFirstValue("words");
        if (words == null) {
            msg = "No words were given for the adage.\n";
            status = Status.CLIENT_ERROR_BAD_REQUEST;
        } else {
            Adages.add(words);
            msg = "The adage '" + words + "' has been added.\n";
            status = Status.SUCCESS_OK;
        }
        setStatus(status);
        return new StringRepresentation(msg, MediaType.TEXT_PLAIN);
    }

}
