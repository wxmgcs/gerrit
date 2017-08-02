// Copyright (C) 2017 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.server.account.externalids;

import com.google.common.collect.ImmutableSetMultimap;
import com.google.gerrit.reviewdb.client.Account;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.eclipse.jgit.lib.ObjectId;

public class DisabledExternalIdCache implements ExternalIdCache {
  public static Module module() {
    return new AbstractModule() {

      @Override
      protected void configure() {
        bind(ExternalIdCache.class).to(DisabledExternalIdCache.class);
      }
    };
  }

  @Override
  public void onCreate(ObjectId oldNotesRev, ObjectId newNotesRev, Collection<ExternalId> extId) {}

  @Override
  public void onUpdate(ObjectId oldNotesRev, ObjectId newNotesRev, Collection<ExternalId> extId) {}

  @Override
  public void onReplace(
      ObjectId oldNotesRev,
      ObjectId newNotesRev,
      Account.Id accountId,
      Collection<ExternalId> toRemove,
      Collection<ExternalId> toAdd) {}

  @Override
  public void onReplaceByKeys(
      ObjectId oldNotesRev,
      ObjectId newNotesRev,
      Account.Id accountId,
      Collection<ExternalId.Key> toRemove,
      Collection<ExternalId> toAdd) {}

  @Override
  public void onReplaceByKeys(
      ObjectId oldNotesRev,
      ObjectId newNotesRev,
      Collection<ExternalId.Key> toRemove,
      Collection<ExternalId> toAdd) {}

  @Override
  public void onReplace(
      ObjectId oldNotesRev,
      ObjectId newNotesRev,
      Collection<ExternalId> toRemove,
      Collection<ExternalId> toAdd) {}

  @Override
  public void onRemove(ObjectId oldNotesRev, ObjectId newNotesRev, Collection<ExternalId> extId) {}

  @Override
  public void onRemoveByKeys(
      ObjectId oldNotesRev,
      ObjectId newNotesRev,
      Account.Id accountId,
      Collection<ExternalId.Key> extIdKeys) {}

  @Override
  public void onRemoveByKeys(
      ObjectId oldNotesRev, ObjectId newNotesRev, Collection<ExternalId.Key> extIdKeys) {}

  @Override
  public Set<ExternalId> byAccount(Account.Id accountId) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ImmutableSetMultimap<Account.Id, ExternalId> allByAccount() throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  public ImmutableSetMultimap<String, ExternalId> byEmails(String... emails) throws IOException {
    throw new UnsupportedOperationException();
  }

  @Override
  public ImmutableSetMultimap<String, ExternalId> allByEmail() throws IOException {
    throw new UnsupportedOperationException();
  }
}
