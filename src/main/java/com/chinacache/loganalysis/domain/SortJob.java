package com.chinacache.loganalysis.domain;

public class SortJob implements Comparable<SortJob> {
	private String channel_id;
	private int priority;

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channel_id == null) ? 0 : channel_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortJob other = (SortJob) obj;
		if (channel_id == null) {
			if (other.channel_id != null)
				return false;
		} else if (!channel_id.equals(other.channel_id))
			return false;
		return true;
	}

	@Override
	public int compareTo(SortJob o) {
		int thisVal = this.getPriority();
		int anotherVal = o.getPriority();
		return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
	}

}
