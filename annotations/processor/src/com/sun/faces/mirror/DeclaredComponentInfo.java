/*
 * Copyright (c) 2007, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.mirror;

import com.sun.faces.annotation.Component;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.rave.designtime.CategoryDescriptor;
import com.sun.rave.designtime.Constants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Represents a JSF component class declared in the current compilation unit.
 *
 * @author gjmurphy
 */
public class DeclaredComponentInfo extends DeclaredClassInfo {
    
    // Annotation element names
    static final String TYPE = "type";
    static final String FAMILY = "family";
    static final String DISPLAY_NAME = "displayName";
    static final String INSTANCE_NAME = "instanceName";
    static final String TAG_NAME = "tagName";
    static final String TAG_RENDERER_TYPE = "tagRendererType";
    static final String SHORT_DESCRIPTION = "shortDescription";
    static final String HELP_KEY = "helpKey";
    static final String IS_CONTAINER = "isContainer";
    static final String IS_TAG = "isTag";
    static final String PROPERTIES_HELP_KEY = "propertiesHelpKey";
    
    Map<String,Object> annotationValueMap;
    
    DeclaredComponentInfo(Map<String,Object> annotationValueMap, ClassDeclaration decl) {
        super(decl);
        this.annotationValueMap = annotationValueMap;
    }
    
    public String getType() {
        String type = (String) this.annotationValueMap.get(TYPE);
        if (type == null)
            type = this.decl.getQualifiedName();
        return type;
    }
    
    public String getFamily() {
        String family = (String) this.annotationValueMap.get(FAMILY);
        if (family == null)
            family = this.getType();
        return family;
    }
    
    public String getShortDescription() {
        String shortDescription = (String) this.annotationValueMap.get(SHORT_DESCRIPTION);
        if (shortDescription == null) {
            String comment = this.getDocComment();
            if (comment == null || comment.trim().length() == 0) {
                shortDescription = this.getDisplayName();
            } else {
                char[] chars = comment.toCharArray();
                StringBuffer buffer = new StringBuffer();
                int index = 0;
                while (index < chars.length && Character.isSpaceChar(chars[index]))
                    index++;
                while (index < chars.length) {
                    if (chars[index] == '<') {
                        index++;
                        while (index < chars.length && chars[index] != '>')
                            index++;
                    } else if (chars[index] == '\n') {
                        buffer.append(" ");
                    } else if (chars[index] == '"') {
                        buffer.append("&quot;");
                    } else if (chars[index] == '.') {
                        if (index == chars.length - 1 || Character.isSpaceChar(chars[index+1]))
                            break;
                        buffer.append('.');
                    } else {
                        buffer.append(chars[index]);
                    }
                    index++;
                }
                shortDescription = buffer.toString();
            }
        }
        return shortDescription;
    }
    
    public String getDisplayName() {
        String displayName = (String) this.annotationValueMap.get(DISPLAY_NAME);
        if (displayName == null)
            displayName = this.decl.getSimpleName();
        return displayName;
    }
    
    public String getInstanceName() {
        String instanceName = (String) this.annotationValueMap.get(INSTANCE_NAME);
        if (instanceName == null) {
            String name = this.decl.getSimpleName();
            instanceName = name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        return instanceName;
    }
    
    public boolean isTag() {
        Boolean isTag = (Boolean) this.annotationValueMap.get(IS_TAG);
        if (isTag == null)
            return true;
        return isTag.booleanValue();
    }
    
    public String getTagName() {
        String tagName = (String) this.annotationValueMap.get(TAG_NAME);
        if (tagName == null)
            tagName = this.getInstanceName();
        return tagName;
    }
    
    private String tagRendererType;
    
    public String getTagRendererType() {
        if (this.tagRendererType == null)
            return (String) this.annotationValueMap.get(TAG_RENDERER_TYPE);
        return this.tagRendererType;
    }
    
    void setTagRendererType(String tagRendererType) {
        this.tagRendererType = tagRendererType;
    }
    
    private ClassDeclaration tagClassDeclaration;
    
    /**
     * Returns the tag class declaration that was found in the current compilation
     * unit for this component, or null if none was found.
     */
    public ClassDeclaration getTagClassDeclaration() {
        return this.tagClassDeclaration;
    }
    
    void setTagClassDeclaration(ClassDeclaration tagClassDeclaration) {
        this.tagClassDeclaration = tagClassDeclaration;
    }
    
    public String getTagClassQualifiedName() {
        ClassDeclaration tagClassDecl = this.getTagClassDeclaration();
        if (tagClassDecl == null)
            return this.getQualifiedName() + "Tag";
        return tagClassDecl.getQualifiedName();
    }
    
    private String tagDescription;
    
    /**
     * Returns the description of this component's tag, appropriate for use as a description
     * element in the taglib configuration. If no tag description was set, returns the
     * class doc comment.
     */
    public String getTagDescription() {
        if (tagDescription == null) {
            return this.getDocComment();
        }
        return this.tagDescription;
    }
    
    void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }
    
    public String getHelpKey() {
        String helpKey = (String) this.annotationValueMap.get(HELP_KEY);
        return helpKey == null ? "" : helpKey;
    }
    
    public String getPropertiesHelpKey() {
        String propertiesHelpKey = (String) this.annotationValueMap.get(PROPERTIES_HELP_KEY);
        return propertiesHelpKey == null ? "" : propertiesHelpKey;
    }
    
    public Boolean isContainer() {
        return Boolean.TRUE.equals(this.annotationValueMap.get(IS_CONTAINER)) ? Boolean.TRUE : Boolean.FALSE;
    }
    
}
