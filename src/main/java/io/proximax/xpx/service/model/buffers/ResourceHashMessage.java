/*
 * Copyright 2018 ProximaX Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// automatically generated by the FlatBuffers compiler, do not modify
package io.proximax.xpx.service.model.buffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;




/**
 * The Class ResourceHashMessage.
 */
@SuppressWarnings("unused")
public final class ResourceHashMessage extends Table {
  
  /**
   * Gets the root as resource hash message.
   *
   * @param _bb the bb
   * @return the root as resource hash message
   */
  public static ResourceHashMessage getRootAsResourceHashMessage(ByteBuffer _bb) { return getRootAsResourceHashMessage(_bb, new ResourceHashMessage()); }
  
  /**
   * Gets the root as resource hash message.
   *
   * @param _bb the bb
   * @param obj the obj
   * @return the root as resource hash message
   */
  public static ResourceHashMessage getRootAsResourceHashMessage(ByteBuffer _bb, ResourceHashMessage obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  
  /**
   * Inits the.
   *
   * @param _i the i
   * @param _bb the bb
   */
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  
  /**
   * Assign.
   *
   * @param _i the i
   * @param _bb the bb
   * @return the resource hash message
   */
  public ResourceHashMessage __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * Digest.
   *
   * @return the string
   */
  public String digest() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  
  /**
   * Digest as byte buffer.
   *
   * @return the byte buffer
   */
  public ByteBuffer digestAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  
  /**
   * Hash.
   *
   * @return the string
   */
  public String hash() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  
  /**
   * Hash as byte buffer.
   *
   * @return the byte buffer
   */
  public ByteBuffer hashAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  
  /**
   * Keywords.
   *
   * @return the string
   */
  public String keywords() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  
  /**
   * Keywords as byte buffer.
   *
   * @return the byte buffer
   */
  public ByteBuffer keywordsAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  
  /**
   * Meta data.
   *
   * @return the string
   */
  public String metaData() { int o = __offset(10); return o != 0 ? __string(o + bb_pos) : null; }
  
  /**
   * Meta data as byte buffer.
   *
   * @return the byte buffer
   */
  public ByteBuffer metaDataAsByteBuffer() { return __vector_as_bytebuffer(10, 1); }
  
  /**
   * Name.
   *
   * @return the string
   */
  public String name() { int o = __offset(12); return o != 0 ? __string(o + bb_pos) : null; }
  
  /**
   * Name as byte buffer.
   *
   * @return the byte buffer
   */
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(12, 1); }
  
  /**
   * Size.
   *
   * @return the int
   */
  public int size() { int o = __offset(14); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  
  /**
   * Timestamp.
   *
   * @return the long
   */
  public long timestamp() { int o = __offset(16); return o != 0 ? bb.getLong(o + bb_pos) : 0L; }
  
  /**
   * Type.
   *
   * @return the string
   */
  public String type() { int o = __offset(18); return o != 0 ? __string(o + bb_pos) : null; }
  
  /**
   * Type as byte buffer.
   *
   * @return the byte buffer
   */
  public ByteBuffer typeAsByteBuffer() { return __vector_as_bytebuffer(18, 1); }

  /**
   * Creates the resource hash message.
   *
   * @param builder the builder
   * @param digestOffset the digest offset
   * @param hashOffset the hash offset
   * @param keywordsOffset the keywords offset
   * @param metaDataOffset the meta data offset
   * @param nameOffset the name offset
   * @param size the size
   * @param timestamp the timestamp
   * @param typeOffset the type offset
   * @return the int
   */
  public static int createResourceHashMessage(FlatBufferBuilder builder,
      int digestOffset,
      int hashOffset,
      int keywordsOffset,
      int metaDataOffset,
      int nameOffset,
      int size,
      long timestamp,
      int typeOffset) {
    builder.startObject(8);
    ResourceHashMessage.addTimestamp(builder, timestamp);
    ResourceHashMessage.addType(builder, typeOffset);
    ResourceHashMessage.addSize(builder, size);
    ResourceHashMessage.addName(builder, nameOffset);
    ResourceHashMessage.addMetaData(builder, metaDataOffset);
    ResourceHashMessage.addKeywords(builder, keywordsOffset);
    ResourceHashMessage.addHash(builder, hashOffset);
    ResourceHashMessage.addDigest(builder, digestOffset);
    return ResourceHashMessage.endResourceHashMessage(builder);
  }

  /**
   * Start resource hash message.
   *
   * @param builder the builder
   */
  public static void startResourceHashMessage(FlatBufferBuilder builder) { builder.startObject(8); }
  
  /**
   * Adds the digest.
   *
   * @param builder the builder
   * @param digestOffset the digest offset
   */
  public static void addDigest(FlatBufferBuilder builder, int digestOffset) { builder.addOffset(0, digestOffset, 0); }
  
  /**
   * Adds the hash.
   *
   * @param builder the builder
   * @param hashOffset the hash offset
   */
  public static void addHash(FlatBufferBuilder builder, int hashOffset) { builder.addOffset(1, hashOffset, 0); }
  
  /**
   * Adds the keywords.
   *
   * @param builder the builder
   * @param keywordsOffset the keywords offset
   */
  public static void addKeywords(FlatBufferBuilder builder, int keywordsOffset) { builder.addOffset(2, keywordsOffset, 0); }
  
  /**
   * Adds the meta data.
   *
   * @param builder the builder
   * @param metaDataOffset the meta data offset
   */
  public static void addMetaData(FlatBufferBuilder builder, int metaDataOffset) { builder.addOffset(3, metaDataOffset, 0); }
  
  /**
   * Adds the name.
   *
   * @param builder the builder
   * @param nameOffset the name offset
   */
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(4, nameOffset, 0); }
  
  /**
   * Adds the size.
   *
   * @param builder the builder
   * @param size the size
   */
  public static void addSize(FlatBufferBuilder builder, int size) { builder.addInt(5, size, 0); }
  
  /**
   * Adds the timestamp.
   *
   * @param builder the builder
   * @param timestamp the timestamp
   */
  public static void addTimestamp(FlatBufferBuilder builder, long timestamp) { builder.addLong(6, timestamp, 0L); }
  
  /**
   * Adds the type.
   *
   * @param builder the builder
   * @param typeOffset the type offset
   */
  public static void addType(FlatBufferBuilder builder, int typeOffset) { builder.addOffset(7, typeOffset, 0); }
  
  /**
   * End resource hash message.
   *
   * @param builder the builder
   * @return the int
   */
  public static int endResourceHashMessage(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  
  /**
   * Finish resource hash message buffer.
   *
   * @param builder the builder
   * @param offset the offset
   */
  public static void finishResourceHashMessageBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
}
