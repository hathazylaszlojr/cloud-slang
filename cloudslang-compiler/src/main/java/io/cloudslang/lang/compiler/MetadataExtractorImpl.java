/*******************************************************************************
 * (c) Copyright 2016 Hewlett-Packard Development Company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *******************************************************************************/
package io.cloudslang.lang.compiler;

import io.cloudslang.lang.compiler.modeller.MetadataModeller;
import io.cloudslang.lang.compiler.modeller.model.Metadata;
import io.cloudslang.lang.compiler.parser.MetadataParser;
import org.apache.commons.lang.Validate;

import java.util.Map;

public class MetadataExtractorImpl implements MetadataExtractor {

    private MetadataModeller metadataModeller;

    private MetadataParser metadataParser;

    @Override
    public Metadata extractMetadata(SlangSource source) {
        Validate.notNull(source, "You must supply a source to extract the metadata from");
        Map<String, String> metadataMap = metadataParser.parse(source);
        return metadataModeller.createModel(metadataMap);
    }

    public void setMetadataModeller(MetadataModeller metadataModeller) {
        this.metadataModeller = metadataModeller;
    }

    public void setMetadataParser(MetadataParser metadataParser) {
        this.metadataParser = metadataParser;
    }
}
