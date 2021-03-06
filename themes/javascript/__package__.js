/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
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

dojo.provide("webui.@THEME@.*");

dojo.kwCompoundRequire({
    common: [
        "webui.@THEME@.props",
        "webui.@THEME@.cookie",
        "webui.@THEME@.browser",
        "webui.@THEME@.body",
        "webui.@THEME@.common",
        "webui.@THEME@.formElements"]
});

// For debugging only, obtain all module resources before invoking
// dojo.hostenv.writeIncludes(). This will ensure that JavaScript
// files are accessible to JavaScript debuggers.
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.addRemove");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.calendar");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.commonTasksSection");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.editableList");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.fileChooser");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.orderableList");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.scheduler");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.table");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.tree");
dojo.requireIf(djConfig.isDebug, "webui.@THEME@.wizard");

//-->
