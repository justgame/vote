package me.justgame.vote.common.utils;

import org.apache.commons.codec.binary.Base64;

import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 获取主键ID
 * 
 * @author
 */
public class IdUtil {

	public static String getUID() {
		// mongodb objectId
		final int _time = (int) (System.currentTimeMillis() / 1000);
		final int _inc = _nextInc.getAndIncrement();
		final int _machine = _genmachine;

		byte b[] = new byte[12];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.putInt(_time);
		bb.putInt(_machine);
		bb.putInt(_inc);
		return Base64.encodeBase64URLSafeString(b);
	}

	public static void main(String[] args) throws Exception {
//		for (int i = 0; i < 100; i++) {
//			System.out.println(IdUtil.getUID());
//		}
		String abc = Base64.encodeBase64String("我ai".getBytes());
		System.out.println(abc);
		System.out.println(new String(Base64.decodeBase64(abc)));
	}

	private static AtomicInteger _nextInc = new AtomicInteger((new Random()).nextInt());
	private static final int _genmachine;

	static {

		try {
			int machinePiece;
			{
				try {
					StringBuilder sb = new StringBuilder();
					Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
					while (e.hasMoreElements()) {
						NetworkInterface ni = e.nextElement();
						sb.append(ni.toString());
					}
					machinePiece = sb.toString().hashCode() << 16;
				} catch (Throwable e) {
					machinePiece = (new Random().nextInt()) << 16;
				}
			}

			final int processPiece;
			{
				int processId = new Random().nextInt();
				try {
					processId = java.lang.management.ManagementFactory.getRuntimeMXBean().getName().hashCode();
				} catch (Throwable t) {
				}

				ClassLoader loader = IdUtil.class.getClassLoader();
				int loaderId = loader != null ? System.identityHashCode(loader) : 0;

				StringBuilder sb = new StringBuilder();
				sb.append(Integer.toHexString(processId));
				sb.append(Integer.toHexString(loaderId));
				processPiece = sb.toString().hashCode() & 0xFFFF;
			}

			_genmachine = machinePiece | processPiece;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
